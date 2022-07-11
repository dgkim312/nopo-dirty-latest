package com.tandem6.nopostore.user.service;

import com.tandem6.nopostore.user.domain.User;
import com.tandem6.nopostore.user.mapper.UserMapper;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public DefaultRes getAllUsers() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_USER.label(), userList);
    }
}
