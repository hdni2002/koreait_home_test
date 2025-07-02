package com.koreait.dbms_study.service;


import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
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
        int result = userRepository.addUser(addUserReqDto.toEntity());
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
    public ApiRespDto<User> editUser(EditUserReqDto editUserReqDto){
        Optional<User> user = userRepository.getUserByUserID(editUserReqDto.getUserId());
        if(user.isEmpty()){
            return new ApiRespDto<>("해당유저가 존재하지않습니다.", null);
        }
        int result = userRepository.editUser(editUserReqDto.toEntity());
        if(result == 0 ){
            return new ApiRespDto<>("문제가 발생했습니다.", null);
        }
        return new ApiRespDto<>("성공적으로 수정이 완료되었습니다",null);
    }

    public ApiRespDto<Integer> removeUser(Integer userId){
        Optional<User> user = userRepository.getUserByUserID(userId);
        if(user.isEmpty()){
            return new ApiRespDto<>("해당유저가 존재하지않습니다.", null);
        }
        int result = userRepository.removeUser(userId);
        if(result == 0 ){
            return new ApiRespDto<>("문제가 발생했습니다.", result);
        }
        return new ApiRespDto<>("성공적으로 삭제 되었습니다.",result);
    }
}
