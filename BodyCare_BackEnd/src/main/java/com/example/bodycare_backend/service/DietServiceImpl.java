package com.example.bodycare_backend.service;

import com.example.bodycare_backend.dao.DietDao;
import com.example.bodycare_backend.model.Activity;
import com.example.bodycare_backend.model.Diet;
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
 * fileName : DietServiceImpl
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
@Service
public class DietServiceImpl implements DietService{

    @Autowired
    private DietDao dietDao;

    // 나중에 에러 로그 추적을 위해 하나 만들어둠
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Diet> selectAll(Criteria criteria) {
        return dietDao.selectAll(criteria);
    }

    @Override
    public List<Diet> selectByTitle(Criteria criteria) {
        // 빈 값으로 초기화
        List<Diet> diets = Collections.emptyList();

        // Email 이 Null 인지 체크
        Optional<String> optionalCriteria
                = Optional.ofNullable(criteria.getTitle());

        // 테이블의 총 데이터 건수
        // Null 이면 "" 로 바꿈
//        int totalCount = dietDao.selectTotalCount(optionalCriteria.orElse(""));
//
//        // criteria : 페이징 처리 클래스 객체
//        criteria.setTotalItems(totalCount);
//        // 총 페이지 개수 : 테이블의 총 건수(totalCount) / 페이지당 출력할 데이터 개수(size)
//        criteria.setTotalPages(totalCount / criteria.getSize());

        if(criteria.getTitle() == null){
            // title(제목)이 없으면 전채검색을 함
            diets = dietDao.selectAll(criteria);
        } else {
            // title(제목) 이 있으면 제목 검색을 함
            diets = dietDao.findByTitleContaining(criteria);
        }

        return diets;
    }

    @Override
    public Optional<Diet> save(Diet diet) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 customer 정보 출력
        logger.info("diet {}", diet);

        // customer.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if (diet.getId() == null) {
            dietDao.insertDiet(diet);
        }
        //                  있으면 update 문 호출
//        else {
//            dietDao.updateDiet(diet);
//        }

        // insert 문 후에는 diet 의 id 속성에 값이 저장됨(<selectkey>)
        seqId = diet.getId();
        logger.info("seqId {}", seqId);

        return dietDao.selectById(seqId);
    }

    @Override
    public List<Diet> findByTitleContaining(Criteria criteria)  {
        // 빈 값으로 초기화
        List<Diet> diets = Collections.emptyList();

        // Email 이 Null 인지 체크
        Optional<String> optionalCriteria
                = Optional.ofNullable(criteria.getTitle());

        // 테이블의 총 데이터 건수
        // Null 이면 "" 로 바꿈
        int totalCount = dietDao.selectTotalCount(optionalCriteria.orElse(""));

        // criteria : 페이징 처리 클래스 객체
        criteria.setTotalItems(totalCount);
        // 총 페이지 개수 : 테이블의 총 건수(totalCount) / 페이지당 출력할 데이터 개수(size)
        criteria.setTotalPages(totalCount / criteria.getSize());

        if(criteria.getTitle() == null){
            // title(제목)이 없으면 전채검색을 함
            diets = dietDao.selectAll(criteria);
        } else {
            // title(제목) 이 있으면 제목 검색을 함
            diets = dietDao.findByTitleContaining(criteria);
        }

        return diets;
    }
}
