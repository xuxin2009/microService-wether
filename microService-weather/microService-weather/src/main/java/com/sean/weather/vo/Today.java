package com.sean.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class Today implements Serializable {
    private String temperature;
    private String weather;
    private WeatherId weather_id ;
    private String wind;
    private String week;
    private String city;
    private String date_y;
    private String dressing_index;/*穿衣指数*/
    private String dressing_advice;/*穿衣建议*/
    private String uv_index;	/*紫外线强度*/
    private String comfort_index;/*舒适度指数*/
    private String wash_index;/*洗车指数*/
    private String travel_index;/*旅游指数*/
    private String exercise_index;/*晨练指数*/
    private String drying_index;/*干燥指数*/
}
