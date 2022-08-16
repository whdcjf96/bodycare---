package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.UserDao;
import com.example.bodycare_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : BodyUserDetailService
 * author : jc
 * date : 2022-07-05
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-05         jc          최초 생성
 */
@Service
public class BodyUserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao; // 객체 정의( null => 스프링객체 받기)



    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userDao.findByEmail(email);
    }


    //    유저객체가 null이면 insert하고(유저생성), 아니면 -1 반환하는 메소드
    public int signInUser(User user) {
        if(userDao.findByEmail(user.getEmail()) == null) {
            return userDao.insertUser(user);
        } else{
            return userDao.updateUser(user);
        }
    }





}
