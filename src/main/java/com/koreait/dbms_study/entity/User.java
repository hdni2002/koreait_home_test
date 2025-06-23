package com.koreait.dbms_study.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String username;
    private String email;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}
