package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.bodycare_backend.model
 * fileName : UserDailyRecord
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
public class UserDailyRecord {
    private Long id;
    private String recordDate;
    private float weight;
    private float bodyFat;
    private float muscleMass;
    private String createdTime;
    private String updateTime;
//    유저테이블 fk
    private Long id2;

}
