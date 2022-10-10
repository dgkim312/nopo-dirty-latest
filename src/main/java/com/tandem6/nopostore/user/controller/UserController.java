package com.tandem6.nopostore.user.controller;

import com.tandem6.nopostore.user.domain.User;
import com.tandem6.nopostore.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserByUserId(@PathVariable String userId) {
        User user = User.builder()
                .name("jngkim")
                .gender("M")
                .build();

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity AllUsers() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }
}
