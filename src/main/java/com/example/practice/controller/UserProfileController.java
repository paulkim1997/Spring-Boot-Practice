package com.example.practice.controller;

import com.example.practice.mapper.UserProfileMapper;
import com.example.practice.model.UserProfile;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserProfileController {
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}") //path 안에 있는 id 변수를 사용할 것 --> annotation 필요
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all") //Get Post Put Delete 4가지 방식이 있다
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    //path에 아이디, 이름 전화번호 전달할 수 있다 (path는 1~2가지 parameter전달할 때만 사용
    //일반적으로는 @RequestParam이라고 하는 http protocol에 param으로 전달
    @PutMapping("/user/{id}")
   public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}
