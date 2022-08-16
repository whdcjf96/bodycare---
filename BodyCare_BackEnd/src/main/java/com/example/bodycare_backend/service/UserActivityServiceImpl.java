package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.UserActivityDao;
import com.example.bodycare_backend.model.UserActivity;
import com.example.bodycare_backend.paging.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserActivityServiceImpl
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
@Service
public class UserActivityServiceImpl implements UserActivityService{

    @Autowired
    private UserActivityDao userActivityDao;

    @Autowired
    private Criteria criteria;

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<UserActivity> selectById(Long id) {
//        logger.info("critertia {}", criteria);
        return userActivityDao.selectById(id);
    }

    @Override
    public List<UserActivity> save(UserActivity userActivity) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 userActivity 정보 출력
        logger.info("userActivity {}", userActivity);

        // userActivity.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if (userActivity.getId() == null) {
            userActivityDao.insertUserActivity(userActivity);
        }
        //                  있으면 update 문 호출
        else {
            userActivityDao.updateUserActivity(userActivity);
        }

        // insert 문 후에는 diet 의 id 속성에 값이 저장됨(<selectkey>)
        seqId = userActivity.getUserId();
        criteria.setUserId(seqId);
        logger.info("!!!!!!!!!!!!!!!!!!! {}",criteria.getUserId());
        logger.info("seqId {}", seqId);

        return userActivityDao.selectById(seqId);
    }

    @Override
    public boolean deleteById(Long id) {
        int queryResult =0;
        queryResult = userActivityDao.deleteUserActivity(id);

        return (queryResult >= 1) ? true:false;
    }


}