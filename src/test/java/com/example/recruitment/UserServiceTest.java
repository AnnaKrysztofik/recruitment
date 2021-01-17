package com.example.recruitment;

import com.example.recruitment.repostitory.RequestCounterRepository;
import com.example.recruitment.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @Autowired
    private RequestCounterRepository requestCounterRepository;

    @Autowired
    private  UserService userService;


    @Test
    public void addNewUser(){
        //Arrange

        //Act
        userService.addToTable("login1");
        //Assert
        assertTrue(requestCounterRepository.findByLOGIN("login1").get().getREQUEST_COUNT()==1);

    }
    @Test
    public void changeRequestCounter(){
        //Arrange

        //Act
        userService.addToTable("login3");
        userService.addToTable("login2");
        userService.addToTable("login3");
        userService.addToTable("login4");
        userService.addToTable("login4");
        userService.addToTable("login4");
        userService.addToTable("login4");
        //Assert
        assertTrue(requestCounterRepository.findByLOGIN("login2").get().getREQUEST_COUNT()==1);
        assertTrue(requestCounterRepository.findByLOGIN("login3").get().getREQUEST_COUNT()==2);
        assertTrue(requestCounterRepository.findByLOGIN("login4").get().getREQUEST_COUNT()==4);
    }
}