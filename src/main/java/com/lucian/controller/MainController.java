package com.lucian.controller;

import com.lucian.model.UserEntity;
import com.lucian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by User on 2017/4/23.
 */

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserEntity user) {
        UserEntity tmp = userRepository.findByUsername(user.getUsername());
        if (tmp.getPassword().equals(user.getPassword())) {
            return "login";
        }
        else {
            return "index";
        }
    }
}
