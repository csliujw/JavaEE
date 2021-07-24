package com.imooc.firstappdemo.dao;

import com.imooc.firstappdemo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link com.imooc.firstappdemo.pojo.User}
 */
@Repository
public class UserRepository {

    private ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user) {
        boolean success = false;
        int id = idGenerator.getAndIncrement();
        return repository.put(id, user) == null;
    }
}
