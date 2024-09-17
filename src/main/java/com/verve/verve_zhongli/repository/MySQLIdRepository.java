package com.verve.verve_zhongli.repository;

import com.verve.verve_zhongli.repository.jpa.JPARepository;
import com.verve.verve_zhongli.repository.jpa.VerveId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
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
