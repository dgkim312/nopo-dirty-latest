package com.tandem6.nopostore.starred.domain;

import lombok.Data;

@Data
public class Starred {

    private String user_id;
    private String restaurant_id;
    private Integer star_rating;
    private String created_date;

}
