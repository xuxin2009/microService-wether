package com.sean.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sean.weather.service.CityDataService;
import com.sean.weather.service.WeatherDataService;
import com.sean.weather.vo.Item;
import com.sean.weather.vo.Province;
import com.sean.weather.vo.WeatherResponse;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/6/9.
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final Long TIME_OUT = 60*30L;
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CityDataService cityDataService;

    @Override
    public WeatherResponse getDataByCityName(String cityName) {


        String url = "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=5bd27b1c5ab9ea34da40e7af222a04f6&format=2";
        String key = url;
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        String responseBody = null;

        //首先去redis中查询数据，如果redis中有数据则从redis中取数据，如果没有则从接口中获取
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key))
        {
            responseBody = ops.get(key);
            logger.info("redis has data!");
        }else
        {
            ResponseEntity<String>  responseEntity = restTemplate.getForEntity(url,String.class);
            if(responseEntity.getStatusCodeValue() == 200 )
            {
                responseBody = responseEntity.getBody();
                ops.set(url,responseBody,TIME_OUT, TimeUnit.SECONDS);
                logger.error("redis don't has data!");
            }
        }
        try {
            weatherResponse = objectMapper.readValue(responseBody,WeatherResponse.class);
        } catch (IOException e) {
            logger.error("json反序列化失败",e);
        }
        return weatherResponse;
    }

    @Override
    public void getAllCityWeatherData(){
        //获取全部城市名字
        try {
            List<Province> provinceList =  cityDataService.getCityList();
            for (Province province : provinceList)
            {
                List<Item> cityList = province.getItemList();
                for(Item city: cityList)
                {
                    saveWeatherDataToRedis(city.getItem());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveWeatherDataToRedis(String cityName)
    {
        String url = "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=5bd27b1c5ab9ea34da40e7af222a04f6&format=2";
        String key = url;

       ResponseEntity<String> responseEntity =  restTemplate.getForEntity(url,String.class);

        if(responseEntity.getStatusCodeValue() == 200)
        {
          String responseBody = responseEntity.getBody();

            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
            ops.set(key,responseBody,1,TimeUnit.HOURS);
        }

    }


}
