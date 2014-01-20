package service;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Console;
import model.Game;
import org.springframework.stereotype.Service;
import repository.ConsoleRepository;

import javax.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;

@Service
public class JsonConverter {

    ConsoleRepository consoleRepository;

    final ObjectMapper objectMapper;

    @Inject
    public JsonConverter(ConsoleRepository consoleRepository) {
        objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
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

    private final JsonDeserializer<Game> GAME_JSON_DESERIALIZER = new JsonDeserializer<Game>() {

        @Override
        public Game deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            jsonParser.getValueAsString();

            Game game = new Game(node.get("title").toString());
            Console console = consoleRepository.findById(Long.parseLong(node.get("console_id").toString()));
            game.setConsole(console);

            return game;
        }
    };

    private final JsonSerializer<Game> GAME_JSON_SERIALIZER = new JsonSerializer<Game>() {


        public Game deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            jsonParser.getValueAsString();

            Game game = new Game(node.get("title").toString());
            Console console = consoleRepository.findById(Long.parseLong(node.get("console_id").toString()));
            game.setConsole(console);

            return game;
        }

        @Override
        public void serialize(Game game, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException, JsonProcessingException {

            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", game.getId());
            jsonGenerator.writeStringField("title", String.valueOf(game.getTitle()));
            jsonGenerator.writeNumberField("console_id", game.getConsole().getId());

            jsonGenerator.writeEndObject();
        }
    };

    private Module initModule() {
        SimpleModule module = new SimpleModule("GameManagerModul", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Game.class, GAME_JSON_DESERIALIZER);
        module.addSerializer(Game.class, GAME_JSON_SERIALIZER);
        return module;
    }

}
