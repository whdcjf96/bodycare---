package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.UserActivity;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserActivityService
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
public interface UserActivityService {
    //    활동관리페이지에서 조회
    public List<UserActivity> selectById(Long id);

    // 활동 저장 메소드(insert)
    List<UserActivity> save(UserActivity userActivity);

//    활동내역 삭제 메소드
    boolean deleteById(Long id);


}
