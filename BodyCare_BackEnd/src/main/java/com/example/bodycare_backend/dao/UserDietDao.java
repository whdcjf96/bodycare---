package com.example.bodycare_backend.dao;

import com.example.bodycare_backend.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import com.example.bodycare_backend.model.UserDiet;
import sun.awt.SunToolkit;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.bodycare_backend.dao
 * fileName : UserDiet
 * author : jc
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         jc          최초 생성
 */
@Mapper
public interface UserDietDao {

//    식단관리페이지에서 아침조회
    List<UserDiet> selectByUserId(Criteria criteria);

    List<UserDiet> selectAll();


//    List<UserDiet> findAll(Long id);

//    인풋창에서 데이터 삽입
    Long insertDiet(UserDiet userDiet);
    Long updateDiet(UserDiet userDiet);
    Long deleteDiet(Criteria criteria);


    


}
