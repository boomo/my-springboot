package com.hly.chapter322.dao.mapper;

import com.hly.chapter322.entity.Score;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Score findByName(String name);

    @Query("from Score s where s.course=:kc")
    Score findScoreObj(@Param("kc") String course);
}
