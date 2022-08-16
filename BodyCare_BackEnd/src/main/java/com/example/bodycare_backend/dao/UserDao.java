package com.example.bodycare_backend.dao;

import com.example.bodycare_backend.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.dao
 * fileName : UserDao
 * author : jc
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         jc          최초 생성
 */
@Mapper
public interface UserDao {

    List<User> findAll();

    Optional<User> findById(Long id);

    User findByEmail(String email);

    int insertUser(User user);


    int updateUser(User user);

    int updateUserAmr(User user);
//    Long updateBasic(User user);
//    Long updateExer(User user);
}
