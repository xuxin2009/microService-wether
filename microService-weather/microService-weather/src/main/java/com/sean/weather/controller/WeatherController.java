package com.sean.weather.controller;

import com.sean.weather.service.CityDataService;
import com.sean.weather.service.WeatherDataService;
import com.sean.weather.vo.Item;
import com.sean.weather.vo.Province;
import com.sean.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName)
    {
        return weatherDataService.getDataByCityName(cityName);
    }
}
