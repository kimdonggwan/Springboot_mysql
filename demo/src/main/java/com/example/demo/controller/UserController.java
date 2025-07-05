package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 특정 사용자 조회 (GET /api/users/{id})
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // 특정 사용자 이름으로 조회 (GET /api/users/username/{username}) - 선택 사항
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
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