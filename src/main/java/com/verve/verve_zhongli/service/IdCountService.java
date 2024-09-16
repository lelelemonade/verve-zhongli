package com.verve.verve_zhongli.service;

import com.verve.verve_zhongli.repository.IdRepository;
import com.verve.verve_zhongli.repository.MemIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdCountService {

    private final IdRepository idRepository;

    @Autowired
    public IdCountService(MemIdRepository idRepository) {
        this.idRepository = idRepository;
    }

    public void record(String id) {
        idRepository.record(id);
    }
}
