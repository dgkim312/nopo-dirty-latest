package com.tandem6.nopostore.starred.mapper;

import com.tandem6.nopostore.starred.controller.dto.RequestStarredCreateDTO;
import com.tandem6.nopostore.starred.domain.Starred;
import com.tandem6.nopostore.store.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StarredMapper {
    @Select("SELECT * FROM star_rating limit 1000")
    List<Starred> findAll();

    @Insert("INSERT INTO~~")
    void insertStarred(RequestStarredCreateDTO requestStarredCreateDTO);
}
