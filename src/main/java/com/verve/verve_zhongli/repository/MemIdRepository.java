package com.verve.verve_zhongli.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class MemIdRepository implements IdRepository {

    // memory storage for basic requirement
    private final HashSet<String> idCountSet;

    @Autowired
    public MemIdRepository() {
        this.idCountSet = new HashSet<>();
    }

    public void record(String id) {
        idCountSet.add(id);
    }

    public int count() {
        return idCountSet.size();
    }
}
