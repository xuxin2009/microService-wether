package com.sean.weather.service;

import com.sean.weather.vo.Item;
import com.sean.weather.vo.Province;

import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface CityDataService {


    List<Province> getCityList()throws Exception;
}
