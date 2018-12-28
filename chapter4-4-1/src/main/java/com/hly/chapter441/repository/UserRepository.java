package com.hly.chapter441.repository;

import com.hly.chapter441.entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(cacheNames = "allusers")
    @Override
    List<User> findAll();

    @Cacheable(cacheNames = "user")
    @CachePut(value = "user")
    User findById(int id);
}
