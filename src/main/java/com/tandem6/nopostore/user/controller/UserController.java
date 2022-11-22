package com.tandem6.nopostore.user.controller;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.tandem6.nopostore.user.controller.dto.UserResponseDTO;
import com.tandem6.nopostore.user.domain.User;
import com.tandem6.nopostore.user.service.UserService;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@XRayEnabled
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
    public ResponseEntity<UserResponseDTO> getUserByUserId(@PathVariable String userId) {
        return new ResponseEntity(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultRes<List<User>>> allUsers() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }
}
