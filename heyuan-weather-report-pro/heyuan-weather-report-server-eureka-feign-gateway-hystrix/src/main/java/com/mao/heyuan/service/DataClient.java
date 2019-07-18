package com.mao.heyuan.service;

import com.mao.heyuan.vo.City;
import com.mao.heyuan.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "heyuan-weather-eureka-client-zuul",fallback = DataClientFallback.class)
public interface DataClient {
    //获取城市列表
    @RequestMapping(value = "/city/city/listCity", method = RequestMethod.GET)
    List<City> listCity() throws Exception ;

    //通过城市Id查询对应城市的天气数据
    @RequestMapping(value="/data/weather/cityId",method=RequestMethod.GET)
    WeatherResponse getDataByCityId(@RequestParam("cityId")String cityId);
}
