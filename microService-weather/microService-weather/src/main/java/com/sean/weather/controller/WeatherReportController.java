package com.sean.weather.controller;

import com.sean.weather.service.CityDataService;
import com.sean.weather.service.WeatherDataService;
import com.sean.weather.vo.Item;
import com.sean.weather.vo.Province;
import com.sean.weather.vo.Result;
import com.sean.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/14.
 */
@Controller
@RequestMapping("report/")
public class WeatherReportController {
    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @RequestMapping("/cityName/{cityName}")
    public String getWeatherReportByName(Model model, @PathVariable("cityName") String cityName)
    {
        List<Item> cityList = new ArrayList<Item>();
        try {
            List<Province> provinceList =  cityDataService.getCityList();
            for(Province province:provinceList)
            {
                cityList = province.getItemList();
            }
            model.addAttribute("cityList",cityList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WeatherResponse weatherResponse = weatherDataService.getDataByCityName(cityName);
        Result result =  weatherResponse.getResult();
        model.addAttribute("weatherData",result);

        return "index";
    }
}
