package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserReqDto {
    private String username;
    private String email;


    public User toEntity(AddUserReqDto addUserReqDto){
        return User.builder()
                .username(addUserReqDto.username)
                .email(addUserReqDto.email)
                .build();
    }


}
