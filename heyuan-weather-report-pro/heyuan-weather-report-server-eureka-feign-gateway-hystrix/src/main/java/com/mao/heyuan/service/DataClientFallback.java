package com.mao.heyuan.service;

import com.mao.heyuan.vo.City;
import com.mao.heyuan.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList=null;
        cityList=new ArrayList<>();
        City city=new City();
        city.setCityId("101020100");
        city.setCityName("上海");
        cityList.add(city);
        city=new City();
        city.setCityId("101010100");
        city.setCityName("北京");
        cityList.add(city);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        return null;
    }
}
