package com.verve.verve_zhongli.repository.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VerveId {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
