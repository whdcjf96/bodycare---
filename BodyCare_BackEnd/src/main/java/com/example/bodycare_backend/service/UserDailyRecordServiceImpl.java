package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.UserDailyRecordDao;
import com.example.bodycare_backend.model.UserDailyRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserDailyRecordServiceImpl
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
@Service
public class UserDailyRecordServiceImpl implements UserDailyRecordService {

    @Autowired
    private UserDailyRecordDao userDailyRecordDao;

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<UserDailyRecord> save(UserDailyRecord userDailyRecord) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 userDailyRecord 정보 출력
        logger.info("userDailyRecord {}", userDailyRecord);

        // userActivity.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if (userDailyRecord.getId() == null) {
            userDailyRecordDao.insertRecord(userDailyRecord);
        }
        //                  있으면 update 문 호출
        else {
            userDailyRecordDao.updateRecord(userDailyRecord);
        }

        // insert 문 후에는 diet 의 id 속성에 값이 저장됨(<selectkey>)
        seqId = userDailyRecord.getId();
        logger.info("seqId {}", seqId);

        return userDailyRecordDao.selectById(seqId);
    }

    @Override
    public List<UserDailyRecord> selectById(Long id) {
        return userDailyRecordDao.selectById(id);
    }
}
