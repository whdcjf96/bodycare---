package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.ActivityDao;
import com.example.bodycare_backend.model.Activity;
import com.example.bodycare_backend.paging.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : ActivityServiceImpl
 * author : 4571c
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         4571c          최초 생성
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao; // 객체 정의 ( null => 스프링 객체 )

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());


    // 모든 활동명 조회 서비스
    @Override
    public List<Activity> findAll(Criteria criteria) {
        return activityDao.findAll(criteria);
    }

    @Override
    public List<Activity> findByEmailContaining(Criteria criteria)  {
        // 빈 값으로 초기화
        List<Activity> activities = Collections.emptyList();

        // Email 이 Null 인지 체크
        Optional<String> optionalCriteria
                = Optional.ofNullable(criteria.getActivity());

        // 테이블의 총 데이터 건수
        // Null 이면 "" 로 바꿈
        int totalCount = activityDao.selectTotalCount(optionalCriteria.orElse(""));

        // criteria : 페이징 처리 클래스 객체
        criteria.setTotalItems(totalCount);
        // 총 페이지 개수 : 테이블의 총 건수(totalCount) / 페이지당 출력할 데이터 개수(size)
        criteria.setTotalPages(totalCount / criteria.getSize());

        if(criteria.getActivity() == null){
            // title(제목)이 없으면 전채검색을 함
            activities = activityDao.findAll(criteria);
        } else {
            // title(제목) 이 있으면 제목 검색을 함
            activities = activityDao.findByEmailContaining(criteria);
        }

        return activities;
    }
}
