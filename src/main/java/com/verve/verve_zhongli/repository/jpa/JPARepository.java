package com.verve.verve_zhongli.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends CrudRepository<VerveId,String> {
}
