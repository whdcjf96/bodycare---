package com.example.bodycare_backend.controller;

import com.example.bodycare_backend.model.User;
import com.example.bodycare_backend.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : com.example.bodycare_backend.controller
 * fileName : UserController
 * author : jc
 * date : 2022-07-08
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08         jc          최초 생성
 */
@CrossOrigin(origins = "http://localhost:8081")
// @RestController : 통신을 json 형태로 주고받고 싶을 때 사용
@RestController
// @RequestMapping("/api") : http://localhost:8000/api
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/Users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable("id") Long id){
        User users = userService.findById(id).get();
        logger.info("user {}", users);

        try {
            if(users !=null){
                return new ResponseEntity<Object>(users, HttpStatus.OK);
            }else{
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable("id") Long id, @RequestBody User user){
        try{
            user.setId(id);
            User savedUser = userService.save(user).get();
            return new ResponseEntity<Object>(savedUser,HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/usersAmr2/{id}")
    public ResponseEntity<Object> updateAMR(@PathVariable("id") Long id, @RequestBody User user){
        logger.info("hgjg {}",user);
        try{
            user.setId(id);
            userService.updateAmr(user);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
