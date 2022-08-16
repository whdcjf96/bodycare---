package com.example.bodycare_backend.service;

import com.example.bodycare_backend.model.User;
import com.example.bodycare_backend.model.UserDiet;
import com.example.bodycare_backend.paging.Criteria;


import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.service
 * fileName : UserDietService
 * author : 4571c
 * date : 2022-07-01
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-01         4571c          최초 생성
 */
public interface UserDietService {
    //    식단관리페이지에서 아침조회
    List<UserDiet> selectByUserId(Criteria criteria);

    List<UserDiet> selectAll();

    boolean deleteDiet(Criteria criteria);

    // 인풋창 저장 메소드(insert)
    List<UserDiet> save(UserDiet userDiet);
}
