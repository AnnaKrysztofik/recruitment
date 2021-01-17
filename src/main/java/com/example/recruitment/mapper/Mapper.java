package com.example.recruitment.mapper;

import com.example.recruitment.model.User;
import com.example.recruitment.model.UserDto;

public class Mapper {

    public static UserDto map(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setName(user.getName());
        userDto.setType(user.getType());
        userDto.setAvatarUrl(user.getAvatarUrl());
        userDto.setCreatedAt(user.getCreatedAt());
        if (user.getFollowers()==0) {
            userDto.setCalculations(null);
        }
        else {
                userDto.setCalculations((double)Math.round((6 / (double)user.getFollowers()) * (2 + (double)user.getPublicRepos()) * 100000d) / 100000d);
        }
        return userDto;
    }
}
