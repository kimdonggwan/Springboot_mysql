package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commom.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users") // 이 컨트롤러의 기본 경로
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버의 주소
public class UserController {

    @Autowired
    private UserService userService;

    // 모든 사용자 조회 (GET /api/users)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ApiResponse<User> signup(@RequestBody User user) {
    	User savedUser = userService.signup(user);
    	//return ApiResponse.success("가입 성공!");
    	return new ApiResponse<>(true, savedUser, "회원 가입 성공");
    }
    
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    // 여기에 사용자 추가, 수정, 삭제 API도 추가할 수 있습니다.
    /*
    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id); // URL 경로의 ID를 User 객체에 설정
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    */
}