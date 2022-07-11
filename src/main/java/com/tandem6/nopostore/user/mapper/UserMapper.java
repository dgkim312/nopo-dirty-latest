package com.tandem6.nopostore.user.mapper;

import com.tandem6.nopostore.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user limit 1000")
    List<User> findAll();
}
