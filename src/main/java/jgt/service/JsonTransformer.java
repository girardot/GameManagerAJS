package jgt.service;

import org.springframework.stereotype.Service;
import spark.ResponseTransformer;

import javax.inject.Inject;

@Service
public class JsonTransformer implements ResponseTransformer {

    @Inject
    private JsonConverter jsonConverter;

    @Override
    public String render(Object model) {
        return jsonConverter.convertToJson(model);
    }

}
