package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * packageName : com.example.aboutwhaleb.model
 * fileName : JwtReponse
 * author : 4571c
 * date : 2022-06-17
 * description : 클라이언트로 응답을 보낼 클래스(객체)(웹토큰 포함)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-17         4571c          최초 생성
 */
@Setter
@Getter
@ToString
public class JwtResponse {
    // 웹 토큰
    private String token;

    private String type = "Bearer"; // JWT(Java Web Token) 를 보낼때 사용될 타입
    private Long id;
    private String email;
    private String name;
    private List<String> roles; // 역할 (ROLE_ADMIN, ROLE_USER 등등)

    private float height;
    private int age;
    private char gender;

    // type 을 제외한 모든 매개변수가 있는 생성자 정의
    public JwtResponse(String token, Long id, String email, String name, List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.name = name;
        this.roles = roles;
    }
}
