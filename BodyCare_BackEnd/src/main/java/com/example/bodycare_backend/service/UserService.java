package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.User;
import com.example.bodycare_backend.model.UserDailyRecord;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserService
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User findByEmail(String email);

    // 유저정보 저장 메소드(insert)
    Optional<User> save(User user);

    int updateAmr(User user);

//    Boolean deleteUser(String email);
}
