package jgt.service;


import jdk.nashorn.internal.objects.NativeJava;
import jgt.repository.ToBuyGameRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class GameToBuyService {

    @Inject
    private JsonConverter jsonConverter;

    @Inject
    private ToBuyGameRepository toBuyGameRepository;

    public String findAllByOrder() {
        return jsonConverter.convertToJson(toBuyGameRepository.findAllByOrder());
    }

}
