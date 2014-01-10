package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Service
public class JsonConverter {

    final ObjectMapper objectMapper = new ObjectMapper();

    public String convertToJson(Object toConvert) {
        StringWriter stringWriter = new StringWriter();

        try {
            objectMapper.writeValue(stringWriter, toConvert);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

}
