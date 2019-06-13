package com.sean.weather.service.impl;

import com.sean.weather.service.CityDataService;
import com.sean.weather.util.XmlBuilder;
import com.sean.weather.vo.Item;
import com.sean.weather.vo.Cities;
import com.sean.weather.vo.Province;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
@Service
public class CityDataServiceImpl  implements CityDataService{
    @Override
    public List<Province> getCityList() throws Exception {

        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String  line = "";

        while ((line = br.readLine())!= null)
        {
            buffer.append(line);
        }
        br.close();
        Cities cities =(Cities) XmlBuilder.xmlStrToObject(Cities.class,buffer.toString());
        return cities.getProvinceList();
    }

}
