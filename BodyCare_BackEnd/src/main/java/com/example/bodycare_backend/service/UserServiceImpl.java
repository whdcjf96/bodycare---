package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.UserDao;
import com.example.bodycare_backend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserServiceImpl
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        logger.info("userDao", userDao.findById(id));
        return userDao.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Optional<User> save(User user) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 user 정보 출력
        logger.info("user {}", user);

        // customer.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if (user.getId() == null) {
            userDao.insertUser(user);
        }
        //                  있으면 update 문 호출
        else {
            userDao.updateUser(user);
        }

        // insert 문 후에는 customer 의 id 속성에 값이 저장됨(<selectkey>)
        seqId = user.getId();
        logger.info("seqId {}", seqId);

        return userDao.findById(seqId);
    }

    @Override
    public int updateAmr(User user) {
        return userDao.updateUserAmr(user);
    }

    //    @Override
//    public Boolean deleteUser(String email) {
//        boolean queryResult = false;
//
//        queryResult = userDao.deleteUser(email);
//
//        return (queryResult >= 1) ? true : false;
//    }
}
