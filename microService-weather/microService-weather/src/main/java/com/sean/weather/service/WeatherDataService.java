package com.sean.weather.service;

import com.sean.weather.vo.WeatherResponse;

/**
 * Created by Administrator on 2019/6/9.
 */
public interface WeatherDataService {
    WeatherResponse getDataByCityName(String cityName);

    void getAllCityWeatherData();
}
