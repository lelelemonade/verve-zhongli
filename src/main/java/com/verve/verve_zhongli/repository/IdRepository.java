package com.verve.verve_zhongli.repository;

public interface IdRepository {
    void record(String id);

    long count();
}
