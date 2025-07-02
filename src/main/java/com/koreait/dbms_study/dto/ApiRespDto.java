package com.koreait.dbms_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRespDto<T> {
    private String message;
    private T data;

}
