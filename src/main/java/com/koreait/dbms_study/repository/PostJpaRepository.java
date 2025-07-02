package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.entity.JpaPost;
import com.koreait.dbms_study.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<JpaPost, Integer> {
}
