package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.UserDietDao;
import com.example.bodycare_backend.model.UserDiet;
import com.example.bodycare_backend.paging.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserDietServiceImpl
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
@Service
public class UserDietServiceImpl implements UserDietService {
    @Autowired
    Criteria criteria;

    @Autowired
    private UserDietDao userDietDao;

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<UserDiet> selectByUserId(Criteria criteria) {
        return userDietDao.selectByUserId(criteria);
    }

    @Override
    public List<UserDiet> save(UserDiet userDiet) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;
        String seqDate="";

        // 매개변수 userDiet 정보 출력
        logger.info("userDiet {}", userDiet);


        // customer.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if (userDiet.getId() == null) {
            userDietDao.insertDiet(userDiet);
        }
        //                  있으면 update 문 호출
        else {
            userDietDao.updateDiet(userDiet);
        }

        // insert 문 후에는 customer 의 id 속성에 값이 저장됨(<selectkey>)
        logger.info("getUserId {}", userDiet.getUserId());
        logger.info("getDietDate {}", userDiet.getDietDate());
        seqId = userDiet.getUserId();
        seqDate =userDiet.getDietDate();
        logger.info("seqId1 {}", seqId);
        logger.info("seqDate1 {}", seqDate);

        criteria.setUserId(seqId);
        logger.info("333333");

        criteria.setDietDate(seqDate);
        logger.info("seqId2 {}", seqId);
        logger.info("seqDate2 {}", seqDate);
        logger.info("---------------");
        logger.info("criteria {}", criteria);


        return userDietDao.selectByUserId(criteria);
    }

    @Override
    public List<UserDiet> selectAll() {
        return userDietDao.selectAll();
    }

    @Override
    public boolean deleteDiet(Criteria criteria) {
        int queryResult = 0;

        queryResult = Math.toIntExact(userDietDao.deleteDiet(criteria));

        return (queryResult >= 1) ? true : false;
    }
}
