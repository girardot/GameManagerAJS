package jgt.service;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jgt.model.Console;
import jgt.model.Game;
import jgt.model.GameProgression;
import jgt.repository.ConsoleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Service
public class JsonConverter {

    private ConsoleRepository consoleRepository;

    final ObjectMapper objectMapper;

    @Inject
    public JsonConverter(ConsoleRepository consoleRepository) {
        objectMapper = new ObjectMapper();
        this.consoleRepository = consoleRepository;
        objectMapper.registerModule(initModule());
    }

    public String convertToJson(Object toConvert) {
        StringWriter stringWriter = new StringWriter();

        try {
            objectMapper.writeValue(stringWriter, toConvert);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    public Game convertJsonToGame(String json) {
        Game game = null;

        try {
            game = objectMapper.readValue(json, Game.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return game;
    }

    public GameProgression convertJsonToGameProgression(String json) {
        Map jsonpObject = null;

        try {
            jsonpObject = objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return GameProgression.valueOf((String) jsonpObject.get("status"));
    }

    private final JsonDeserializer<Game> GAME_JSON_DESERIALIZER = new JsonDeserializer<Game>() {

        @Override
        public Game deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            jsonParser.getValueAsString();

            Game game = new Game(node.get("title").asText());
            Console console = consoleRepository.findById(node.get("consoleId").asLong());
            game.setConsole(console);

            return game;
        }
    };

    private final JsonSerializer<Game> GAME_JSON_SERIALIZER = new JsonSerializer<Game>() {

        @Override
        public void serialize(Game game, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException {

            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", game.getId());
            jsonGenerator.writeStringField("title", String.valueOf(game.getTitle()));
            jsonGenerator.writeNumberField("console_id", game.getConsole().getId());
            jsonGenerator.writeStringField("progression", game.getProgression().toString());
            jsonGenerator.writeStringField("percentProgression", game.getPercentProgression().toString());
            jsonGenerator.writeStringField("isDematerialized", game.isDematerialized() != null ? game.isDematerialized().toString() : "false");

            jsonGenerator.writeEndObject();
        }
    };

    private Module initModule() {
        SimpleModule module = new SimpleModule("GameManagerModule", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Game.class, GAME_JSON_DESERIALIZER);
        module.addSerializer(Game.class, GAME_JSON_SERIALIZER);
        return module;
    }

}
