package com.hly.chapter322.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score {
    @Id
    private String name;
    @Column
    private String course;

    @Column
    private Integer cj;
}
