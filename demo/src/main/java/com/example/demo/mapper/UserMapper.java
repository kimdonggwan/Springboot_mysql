package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.User;

//@Mapper
public interface UserMapper {

    // 모든 사용자 조회
    List<User> findAllUsers();

    // ID로 사용자 조회
    User findUserById(int id);

    // 사용자 이름으로 사용자 조회 (선택 사항)
    User findUserByUsername(String username);

    // 여기에 사용자 추가, 수정, 삭제 메서드도 추가할 수 있습니다.
    // 예: void insertUser(User user);
    // 예: void updateUser(User user);
    // 예: void deleteUser(int id);
}