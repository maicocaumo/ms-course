package com.course.hroauth.service;

import com.course.hroauth.entity.User;
import com.course.hroauth.feingclient.UserFeingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserFeingClient userFeingClient;

    public User findByEmail(String email) {
        User user = userFeingClient.findByEmail(email).getBody();

        if(user == null) {
            log.error("Email not found " + email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: " + email);

        return user;
    }
}
