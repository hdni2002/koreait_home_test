package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//mybatis
//SQL 중심의 데이터 접근 프레임워크
// -> 내가 직접 SQL문 작성하고, 그결과를 JAVA 객체로 매핑
//SQL을 직접짜기 때문에 완전히 통제 가능 (자유도 높음), 대신 코드가 복잡하고 반복적이다.
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserReqDto addUserReqDto){
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }
    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList(){
        return ResponseEntity.ok(userService.getUserList());
    }


    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }

//    요청 메소드 중 DELETE, PUT이 있는데 POST로
//    보안상 이유, 호환성 이유
//    일부 브라우저, 서버가 PUT, DELETE를 완벽히 지원하지 않음
//    HTML <form>가 GET, POST만 지원
    @PostMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody EditUserReqDto editUserReqDto){
        return ResponseEntity.ok(userService.editUser(editUserReqDto));
    }
    @PostMapping("/remove")
    public ResponseEntity<?> removeUser(@RequestParam Integer userId){
        return ResponseEntity.ok(userService.removeUser(userId));

    }


}
