package com.example.bodycare_backend.dao;

import com.example.bodycare_backend.model.UserActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.dao
 * fileName : UserActivityDao
 * author : jc
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         jc          최초 생성
 */
@Mapper
public interface UserActivityDao {

//    활동관리페이지에서 조회
    List<UserActivity> selectById(Long id);

//    입력창에서 활동 선택해서 데이터삽입
    Long insertUserActivity(UserActivity userActivity);

    Long updateUserActivity(UserActivity userActivity);

    int deleteUserActivity(Long id);

    int deleteUserActivityAll();


}
