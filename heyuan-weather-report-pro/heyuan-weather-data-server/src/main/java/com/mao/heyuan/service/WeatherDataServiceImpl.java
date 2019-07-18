package com.mao.heyuan.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mao.heyuan.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        return this.doGetWeather(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URL + "city=" + cityName;
        return this.doGetWeather(url);
    }

    private WeatherResponse doGetWeather(String url) {

        String key = url;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("redis has data");
            strBody = ops.get(key);
        } else {
            logger.info("Redis don't has data");
            // 缓存没有，抛出异常
            throw new RuntimeException("Don't has data!");
        }
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error!", e);
        }
        return resp;
    }

}
