package com.verve.verve_zhongli.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("extension-2")
public interface JPARepository extends CrudRepository<VerveId, String> {
}
