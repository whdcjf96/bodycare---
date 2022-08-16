package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.aboutwhaleb.model
 * fileName : MessageResponse
 * author : 4571c
 * date : 2022-06-17
 * description : 클라이언트(Vue)로 전송할 응답 메세지 클래스(객체)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-17         4571c          최초 생성
 */
@Setter
@Getter
@ToString
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
