package com.monir.redisspring.city.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class City {

    private String city;
    private String zip;
    private String stateName;
    private int temperature;
}
