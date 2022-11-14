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

    @Select("select b.MANAGEMENT_NO, b.LICENSE_ISSUE_DATE, b.STORE_NAME, b.LOCATION_ADDRESS, b.BUSINESS_TYPE, a.Ranking\n" +
            "from\n" +
            "     (select RESTAURANT_ID,AVG(STAR_RATING) AS Ranking\n" +
            "      from star_rating group by RESTAURANT_ID) a, restarant b\n" +
            "where a.RESTAURANT_ID = b.MANAGEMENT_NO\n" +
            "    AND b.BUSINESS_STATUS_NAME = '영업/정상'\n" +
            "order by b.LICENSE_ISSUE_DATE asc limit 100;")
    List<Store> findAllStoreOrderByRanking();

    @Select("select b.MANAGEMENT_NO, b.LICENSE_ISSUE_DATE, b.STORE_NAME, b.LOCATION_ADDRESS, b.BUSINESS_TYPE, a.Ranking\n" +
            "from\n" +
            "     (select RESTAURANT_ID,AVG(STAR_RATING) AS Ranking\n" +
            "      from star_rating group by RESTAURANT_ID) a, restarant b\n" +
            "where a.RESTAURANT_ID = b.MANAGEMENT_NO\n" +
            "    AND b.LOCATION_ADDRESS like CONCAT('%',#{location},'%')\n" +
            "    AND b.BUSINESS_STATUS_NAME = '영업/정상'\n" +
            "order by b.LICENSE_ISSUE_DATE asc limit 100;")
    List<Store> findRegionalStoreOrderByRanking(RequestRegionalStoreDTO requestRegionalStoreDTO);
}
