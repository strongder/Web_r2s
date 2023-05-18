package com.r2s.demo.service;

import java.util.List;

public interface BaseService <T, K> {
    T getById(K key);
    List<T> getAll();
    List<T> getPaging(int pageNo, int pageSize, String sortDir, String sortBy);
    T create(T type);
    T update(T type);
}
