package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.Diet;
import com.example.bodycare_backend.paging.Criteria;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : DietService
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
public interface DietService {
    //    인풋창에서 조회
    public List<Diet> selectAll(Criteria criteria);

    //    인풋창에서 타이틀별로 검색
    public List<Diet> selectByTitle(Criteria criteria);

    public List<Diet> findByTitleContaining(Criteria criteria);
    // 음식 저장 메소드(insert)
    Optional<Diet> save(Diet diet);
    
}
