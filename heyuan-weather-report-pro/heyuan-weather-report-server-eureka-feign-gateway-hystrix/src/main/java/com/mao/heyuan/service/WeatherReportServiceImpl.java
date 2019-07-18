package com.mao.heyuan.service;

import com.mao.heyuan.vo.Weather;
import com.mao.heyuan.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {

        WeatherResponse weatherResponse=dataClient.getDataByCityId(cityId);
        Weather data=null;
        if(weatherResponse!=null){
            return  weatherResponse.getData();
        }
        return data;
    }
}
