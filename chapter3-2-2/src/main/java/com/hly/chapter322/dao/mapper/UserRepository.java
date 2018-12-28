package com.hly.chapter322.dao.mapper;

import com.hly.chapter322.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@CacheConfig
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(value = "names1")
    User findById(Integer id);

    @Cacheable(value = "names1")
    List<User> findByName(String name);

    @Cacheable(cacheNames = "names2")
    @Override
    List<User> findAll();
}
