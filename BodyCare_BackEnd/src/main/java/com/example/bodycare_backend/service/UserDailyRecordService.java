package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.UserActivity;
import com.example.bodycare_backend.model.UserDailyRecord;

import java.util.List;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserDailyRecordService
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
public interface UserDailyRecordService {
    // 유저정보 저장 메소드(insert)
    List<UserDailyRecord> save(UserDailyRecord userDailyRecord);

    //    체중추적에서 조회
    List<UserDailyRecord> selectById(Long id);


}
