
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
    	List<User> user = userMapper.findAllUsers();
    
        return userMapper.findAllUsers();
    }

    public void addUser(User user) {
    	userMapper.addUser(user);
    }
    
    public void updateUser(User user) {
    	userMapper.updateUser(user);
    }
    
    public void deleteUser(int id) {
    	userMapper.deleteUser(id);
    }
    
    // 여기에 사용자 추가, 수정, 삭제 메서드도 추가할 수 있습니다.
    // public void addUser(User user) { userMapper.insertUser(user); }
    // public void updateUser(User user) { userMapper.updateUser(user); }
    // public void deleteUser(int id) { userMapper.deleteUser(id); }
}