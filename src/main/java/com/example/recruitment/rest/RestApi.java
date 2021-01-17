package com.example.recruitment.rest;

import com.example.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;


@Controller
public class RestApi {

    @Autowired
    private UserService userService;

    @GetMapping("users/{login}")
    @ResponseBody
    public String getUser(@PathVariable("login") String login){

        try {
            return userService.displayUser(login);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Użytkownik o podanym loginie nie istnieje.";

    }

}
