package jgt.service;


import jgt.repository.ToBuyGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class GameToBuyService {

    @Inject
    private JsonConverter jsonConverter;

    @Inject
    private ToBuyGameRepository toBuyGameRepository;

    @Transactional(readOnly = true)
    public String findAllByOrder() {
        return jsonConverter.convertToJson(toBuyGameRepository.findAllByOrder());
    }

}
