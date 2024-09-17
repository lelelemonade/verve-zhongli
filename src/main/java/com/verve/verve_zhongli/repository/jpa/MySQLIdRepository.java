package com.verve.verve_zhongli.repository.jpa;

import com.verve.verve_zhongli.repository.IdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("extension-2")
@Repository
public class MySQLIdRepository implements IdRepository {

    @Autowired
    private JPARepository jpaRepository;

    @Override
    public void record(String id) {
        VerveId verveId = new VerveId();
        verveId.setId(id);
        jpaRepository.save(verveId);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}
