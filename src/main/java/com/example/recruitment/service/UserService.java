package com.example.recruitment.service;

import com.example.recruitment.mapper.Mapper;
import com.example.recruitment.entity.RequestCounter;
import com.example.recruitment.repostitory.RequestCounterRepository;
import com.example.recruitment.model.User;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class UserService {
    @Autowired
    private RequestCounterRepository requestCounterRepository;

    public String displayUser(String login) throws IOException {
        URL url = new URL ("https://api.github.com/users/"+login);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        User user = new Gson().fromJson(reader, User.class);

        addToTable(login);
        return Mapper.map(user).toString();
    }

    public void addToTable(String login){
        val searchedLogin = requestCounterRepository.findByLOGIN(login);
        if (searchedLogin.isPresent()){
            searchedLogin.get().setREQUEST_COUNT(searchedLogin.get().getREQUEST_COUNT()+1);
            requestCounterRepository.save(searchedLogin.get());
        }

        else{
            val newLogin = new RequestCounter();
            newLogin.setLOGIN(login);
            newLogin.setREQUEST_COUNT(1);
            requestCounterRepository.save(newLogin);
        }
    }
}
