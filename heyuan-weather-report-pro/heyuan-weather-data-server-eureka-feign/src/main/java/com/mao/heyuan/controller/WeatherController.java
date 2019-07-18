package com.mao.heyuan.controller;

import com.mao.heyuan.service.WeatherDataService;
import com.mao.heyuan.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId")
    public WeatherResponse getWeatherByCityId(String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName")
    public WeatherResponse getWeatherByCityName(String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

}
