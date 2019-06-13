package com.sean.weather;

import com.sean.weather.service.CityDataService;
import com.sean.weather.vo.Item;
import com.sean.weather.vo.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MicroServiceWeatherApplicationTests {

	private final static Logger logger = LoggerFactory.getLogger(MicroServiceWeatherApplicationTests.class);
	@Autowired
	private CityDataService cityDataService;

	@Test
	public void contextLoads() {

	}



}
