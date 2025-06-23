package com.koreait.dbms_study.service;


import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Map<String, String>addUser(AddUserReqDto addUserReqDto){
        Map<String, String> response = new HashMap<>();
        int result = userRepository.addUser(addUserReqDto.toEntity(addUserReqDto));
        if (result ==1) {
            response.put("status", "success");
            response.put("message", "추가성공");
            return response;
        }
        response.put("status","failed");
        response.put("message","추가실패");
            return response;
    }
    public List<User> getUserList(){
        return userRepository.getUserList();
    }
    public Map<String, Object> getUserByUserId(Integer userId){
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.getUserByUserID(userId);
        if(user.isEmpty()){
            response.put("message","회원정보가 없습니다.");
            return response;
        }
        response.put("user",user);
        return response;
    }

}
