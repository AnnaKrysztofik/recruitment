package com.example.recruitment;

import com.example.recruitment.mapper.Mapper;
import com.example.recruitment.model.User;
import com.example.recruitment.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MapperTest {

    @Test
    public void calculationIntegers(){
        //Arrange
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setName("imie");
        user.setType("User");
        user.setAvatarUrl("abcd");
        user.setCreatedAt("2011-01-25T18:44:36Z");
        user.setFollowers(1);
        user.setPublicRepos(1);

        //Act
        UserDto map = Mapper.map(user);

        //Assert
        assertEquals(new UserDto(18.0,"login",1,"abcd", "User", "imie",
                "2011-01-25T18:44:36Z"), map);
    }
    @Test
    public void calculation2decimalPlaces(){
        //Arrange
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setName("imie");
        user.setType("User");
        user.setAvatarUrl("abcd");
        user.setCreatedAt("2011-01-25T18:44:36Z");
        user.setFollowers(200);
        user.setPublicRepos(100);

        //Act
        UserDto map = Mapper.map(user);

        //Assert
        assertEquals(new UserDto(3.06,"login",1,"abcd", "User", "imie",
                "2011-01-25T18:44:36Z"), map);
    }

    @Test
    public void calculation5decimalPlaces(){
        //Arrange
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setName("imie");
        user.setType("User");
        user.setAvatarUrl("abcd");
        user.setCreatedAt("2011-01-25T18:44:36Z");
        user.setFollowers(1505);
        user.setPublicRepos(562);

        //Act
        UserDto map = Mapper.map(user);

        //Assert
        assertEquals(new UserDto(2.24850,"login",1,"abcd", "User", "imie",
                "2011-01-25T18:44:36Z"), map);
    }


    @Test
    public void calculationNull(){
        //Arrange
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setName("imie");
        user.setType("User");
        user.setAvatarUrl("abcd");
        user.setCreatedAt("2011-01-25T18:44:36Z");
        user.setFollowers(0);
        user.setPublicRepos(562);

        //Act
        UserDto map = Mapper.map(user);

        //Assert
        assertEquals(new UserDto(null,"login",1,"abcd", "User", "imie",
                "2011-01-25T18:44:36Z"), map);
    }
}