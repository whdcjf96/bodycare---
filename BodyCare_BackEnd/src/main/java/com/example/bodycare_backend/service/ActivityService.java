package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.Activity;
import com.example.bodycare_backend.paging.Criteria;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : ActivityService
 * author : 4571c
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         4571c          최초 생성
 */
public interface ActivityService {
    // 모든 회원 조회하는 메소드(결과 : 여러건)
    public List<Activity> findAll(Criteria criteria);

    public List<Activity> findByEmailContaining(Criteria criteria);
}
