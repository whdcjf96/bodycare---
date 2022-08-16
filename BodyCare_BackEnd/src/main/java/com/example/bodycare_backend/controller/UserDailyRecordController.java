package com.example.bodycare_backend.controller;

import com.example.bodycare_backend.model.UserDailyRecord;
import com.example.bodycare_backend.model.UserDiet;
import com.example.bodycare_backend.paging.Criteria;
import com.example.bodycare_backend.service.DietServiceImpl;
import com.example.bodycare_backend.service.UserDailyRecordServiceImpl;
import com.example.bodycare_backend.service.UserDietServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.bodycare_backend.controller
 * fileName : UserDailyRecordController
 * author : jc
 * date : 2022-07-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-07         jc          최초 생성
 */
@CrossOrigin(origins = "http://localhost:8081")
// @RestController : 통신을 json 형태로 주고받고 싶을 때 사용
@RestController
// @RequestMapping("/api") : http://localhost:8000/api
@RequestMapping("/api")
public class UserDailyRecordController {

    // logger 찍기를 위한 객체 만듬
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired : 스프링 객체 하나 받아오기
    @Autowired
    private UserDailyRecordServiceImpl userDailyRecordService; // 객체 정의( null => 스프링 객체)

    // 조회
    @GetMapping("/userDailyRecords/{userId}")
    public ResponseEntity<Object> getUserDailyRecordById(@PathVariable("userId") Long userId){
        List<UserDailyRecord> userDailyRecords = userDailyRecordService.selectById(userId);
        logger.info("userDailyRecords",userDailyRecords);

        try{
            if(userDailyRecords!=null){
                return new ResponseEntity<Object>(userDailyRecords, HttpStatus.OK);
            }else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // 회원 생성 메뉴
    @PostMapping("/userDailyRecords")
    public ResponseEntity<Object>
    createUserDailyRecord(@RequestBody UserDailyRecord userDailyRecord) {
        // save 리턴값 Optional<Customer> => save(customer).get() 객체를 꺼냄
        List<UserDailyRecord> savedUDR =  userDailyRecordService.save(userDailyRecord);
        try {
            return new ResponseEntity<Object>(savedUDR, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue 에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/userDailyRecords/{id}")
    public ResponseEntity<Object> updateUserDailyRecord(
            @PathVariable("id") Long id,
            @RequestBody UserDailyRecord userDailyRecord
    ) {
        try {
            // customer 에 id 값 저장
            userDailyRecord.setId(id);
            // save : id 가 null 일 경우 insert , id 가 null이 아닐경우 update
            // Optional<Customer> => Customer 객체를 꺼낼려면 get() 메소드를 호출해야함
            List<UserDailyRecord> savedUD =  userDailyRecordService.save(userDailyRecord);
            // Vue 에 DB에 저장된 객체 + 상태메세지를 전송(OK)
            return new ResponseEntity<Object>(savedUD, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue 에 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
