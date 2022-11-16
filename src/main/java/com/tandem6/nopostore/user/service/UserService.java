package com.tandem6.nopostore.user.service;

import com.tandem6.nopostore.user.domain.User;
import com.tandem6.nopostore.user.mapper.UserMapper;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public DefaultRes<List<User>> getAllUsers() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_USER.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_USER.label(), userList);
    }

    public DefaultRes<Object> getUserById(String userId) {
        final User user = userMapper.findById(userId);
        if (user == null)
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_USER.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_USER.label(), user);
    }
}
