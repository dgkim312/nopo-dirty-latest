package com.tandem6.nopostore.store.mapper;

import com.tandem6.nopostore.store.domain.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Select("SELECT * FROM restarant limit 1000")
    List<Store> findAll();
}
