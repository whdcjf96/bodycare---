package com.example.bodycare_backend.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * packageName : com.example.bodycare_backend.model
 * fileName : User
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
public class User implements UserDetails {
    private Long id;
    private String email;
    private String password;
    private String name;
    private char gender;
    private String createdTime;
    private String updateTime;
    private float height;
    private int age;
    private String roles;
    private float weight;
    private float bodyFat;
    private float muscleMass;
    private float kcalStart;
    private float kcalWeekly;
    private float weightGoal;

    private float fatGoal;
    private float amr;
    
    // Serialize 네트워크 전송 자동 생성 번호 => 수동으로 이름을 명시함
    // 보안 관련해서 자동 번호 생성
    private static final long serialVersionUID = 1L;
    // 권한 관련된 정보를 얻는 메소드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 정보를 담을 배열 정의
        ArrayList<GrantedAuthority> auth = new ArrayList<>();
        // SimpleGrantedAuthority 권한 객체를 넣기 : auth 배열
        auth.add(new SimpleGrantedAuthority(roles));

        return auth;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
