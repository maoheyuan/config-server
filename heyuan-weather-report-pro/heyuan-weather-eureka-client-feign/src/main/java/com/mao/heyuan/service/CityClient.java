package com.mao.heyuan.service;

import com.mao.heyuan.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("heyuan-weather-city-server-eureka")
public interface CityClient {
    @RequestMapping(value="/city/listCity",method= RequestMethod.GET)
    List<City> listCity()throws Exception;
}
