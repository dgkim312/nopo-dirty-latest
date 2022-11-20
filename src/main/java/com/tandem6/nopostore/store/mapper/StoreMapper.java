package com.tandem6.nopostore.store.mapper;

import com.tandem6.nopostore.store.controller.dto.RequestRegionalStoreDTO;
import com.tandem6.nopostore.store.domain.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Select("SELECT * FROM restarant limit 1000")
    List<Store> findAll();

    @Select("""
            select b.MANAGEMENT_NO, b.LICENSE_ISSUE_DATE, b.STORE_NAME, b.LOCATION_ADDRESS, b.BUSINESS_TYPE, a.Ranking
            from
                 (select RESTAURANT_ID,AVG(STAR_RATING) AS Ranking
                  from star_rating group by RESTAURANT_ID order by Ranking desc) a, restarant b
            where a.RESTAURANT_ID = b.MANAGEMENT_NO
                AND b.BUSINESS_STATUS_NAME = '영업/정상'
            order by b.LICENSE_ISSUE_DATE asc limit 100;
            """)
    List<Store> findAllStoreOrderByRanking();

    @Select("""
            select b.MANAGEMENT_NO, b.LICENSE_ISSUE_DATE, b.STORE_NAME, b.LOCATION_ADDRESS, b.BUSINESS_TYPE, a.Ranking
            from
                 (select RESTAURANT_ID,AVG(STAR_RATING) AS Ranking
                  from star_rating group by RESTAURANT_ID order by Ranking desc) a, restarant b
            where a.RESTAURANT_ID = b.MANAGEMENT_NO
                AND b.LOCATION_ADDRESS like CONCAT('%',#{location},'%')
                AND b.BUSINESS_STATUS_NAME = '영업/정상'
            order by b.LICENSE_ISSUE_DATE asc limit 100;
            """)
    List<Store> findRegionalStoreOrderByRanking(RequestRegionalStoreDTO requestRegionalStoreDTO);
}


