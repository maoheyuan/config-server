package com.mao.heyuan.service;


import com.mao.heyuan.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("heyuan-weather-data-server-eureka-feign")
public interface WeatherDataClient {
    @RequestMapping(value = "/weather/cityId",method = RequestMethod.GET)
    WeatherResponse getDataByCityId(@RequestParam("cityId") String cityId);
}
