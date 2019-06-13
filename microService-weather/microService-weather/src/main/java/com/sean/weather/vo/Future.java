package com.sean.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class Future implements Serializable{

    private String temperature;
    private String weather;
    private WeatherId weather_id ;
    private String wind;
    private String week;
    private String date;
}
