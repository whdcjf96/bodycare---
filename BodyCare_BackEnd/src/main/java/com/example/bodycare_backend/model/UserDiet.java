package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.bodycare_backend.model
 * fileName : UserDiet
 * author : jc
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         jc          최초 생성
 */
@Getter
@Setter
@ToString
public class UserDiet {
    private Long id;
    private float quantity;
    private String createdTime;
    private String updateTime;
    private Long dietTime;

//    유저테이블 fk
    private Long userId;
//    식단테이블 fk
    private Long dietId;


    private String dietDate;

//    join 컬럼
    private String title;
    private float carbohydrate;
    private float protein;
    private float fat;

}
