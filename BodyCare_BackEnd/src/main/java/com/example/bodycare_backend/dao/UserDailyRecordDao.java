package com.example.bodycare_backend.dao;

import com.example.bodycare_backend.model.UserDailyRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.bodycare_backend.dao
 * fileName : UserDailyRecord
 * author : jc
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         jc          최초 생성
 */
@Mapper
public interface UserDailyRecordDao {

//    기본페이지에서 입력받을때 동시 저장
    Long insertRecord(UserDailyRecord userDailyRecord);

//    체중추적에서 조회
    List<UserDailyRecord> selectById(Long id);

    Long updateRecord(UserDailyRecord userDailyRecord);

    Long deleteRecord(Long id);
}
