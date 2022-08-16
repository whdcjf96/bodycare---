package com.example.bodycare_backend.dao;

import com.example.bodycare_backend.model.Activity;
import com.example.bodycare_backend.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.dao
 * fileName : ActivityDao
 * author : 4571c
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         4571c          최초 생성
 */
@Mapper
public interface ActivityDao {
    // 전체 조회 메소드
    List<Activity> findAll(Criteria criteria);

    public int selectTotalCount(String activity);

    public List<Activity> findByEmailContaining(Criteria criteria);




}
