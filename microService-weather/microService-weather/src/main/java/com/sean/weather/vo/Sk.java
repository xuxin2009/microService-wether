package com.sean.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class Sk implements Serializable{

    private String temp;/*当前温度*/
    private String wind_direction;/*当前风向*/
    private String wind_strength;/*当前风力*/
    private String humidity;/*当前湿度*/
    private String time;/*更新时间*/

}
