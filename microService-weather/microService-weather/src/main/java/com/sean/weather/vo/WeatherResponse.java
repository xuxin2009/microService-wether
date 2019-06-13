package com.sean.weather.vo;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class WeatherResponse {
    private String resultcode;
    private String reason;
    private Result result;
    private String error_code;
}
