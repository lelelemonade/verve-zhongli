package com.verve.verve_zhongli.service;

import com.verve.verve_zhongli.repository.IdRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@EnableScheduling
@Service
public class IdCountFlushService {

    private final IdRepository idRepository;
    private int lastMinuteIdCount;

    @Autowired
    public IdCountFlushService(IdRepository idRepository) {
        this.idRepository = idRepository;
        this.lastMinuteIdCount = idRepository.count();
    }

    // default using spring boot built-in simple thread pool which is totally fine
    @Scheduled(cron = "0 * * * * ?")
    public void flush() {
        int thisMinuteIdCount = idRepository.count();
        log.info("id count:{}", thisMinuteIdCount - lastMinuteIdCount);
        this.lastMinuteIdCount = thisMinuteIdCount;
    }

}
