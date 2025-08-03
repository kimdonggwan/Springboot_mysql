
package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public List<User> getAllUsers() {
    
        return userMapper.findAllUsers();
    }
    
    public boolean signin(User user) {
    	
		User userInfo = userMapper.findUserInfo(user);
		String encodePassword = ((User) userInfo).getPassword();
		
		if (passwordEncoder.matches(user.getPassword(), encodePassword)) {
			return true;
		} 
		
		return false;
    }
    
    public User signup(User user) {
    	
    	String encodePassword = user.getPassword();
    			
    	int cnt = userMapper.findUser(user);
    	
    	if(cnt > 0) {
    		
    	} else {
    		user.setPassword(encodePassword);
    		userMapper.addUser(user);
    	}
    	return user;
    }
    
    public void updateUser(User user) {
    	userMapper.updateUser(user);
    }
    
    public void deleteUser(User user) {
    	userMapper.deleteUser(user);
    }
    
    // 여기에 사용자 추가, 수정, 삭제 메서드도 추가할 수 있습니다.
    // public void addUser(User user) { userMapper.insertUser(user); }
    // public void updateUser(User user) { userMapper.updateUser(user); }
    // public void deleteUser(int id) { userMapper.deleteUser(id); }
}