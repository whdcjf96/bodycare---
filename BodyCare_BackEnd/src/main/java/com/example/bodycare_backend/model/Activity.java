package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.bodycare_backend.model
 * fileName : dkdk
 * author : 4571c
 * date : 2022-06-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-30         4571c          최초 생성
 */
@Getter
@Setter
@ToString
public class Activity {
    private Long id; // 식별번호
    private float intensity; // 활동강도
    private String activity; // 활동명
}
