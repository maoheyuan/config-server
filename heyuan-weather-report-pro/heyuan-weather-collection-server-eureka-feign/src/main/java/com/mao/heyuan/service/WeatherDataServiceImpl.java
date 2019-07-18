package com.mao.heyuan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        this.saveWeatherData(url);
    }


    private void saveWeatherData(String url) {
        String key = url;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
            logger.info(strBody);
        }
        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
