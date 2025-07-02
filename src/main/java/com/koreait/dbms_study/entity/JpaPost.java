package com.koreait.dbms_study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name = "post_tb")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JpaPost {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer postId;
        private String title;
        private String content;
        private Integer userId;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
    }

