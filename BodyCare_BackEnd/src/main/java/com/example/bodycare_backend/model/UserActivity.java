package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.bodycare_backend.model
 * fileName : UserActivity
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
public class UserActivity {
    private Long id;

    private float activityTime;
    private String createdTime;
    private String updateTime;
//    활동테이블 fk
    private Long activityId;
//    유저테이블 fk
    private Long userId;

//    join컬럼
    private String activity;
    private float intensity;
}
