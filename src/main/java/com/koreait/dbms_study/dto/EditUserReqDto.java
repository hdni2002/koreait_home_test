package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditUserReqDto {
    private Integer userId;
    private String username;
    private String email;


    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .build();
    }
}
