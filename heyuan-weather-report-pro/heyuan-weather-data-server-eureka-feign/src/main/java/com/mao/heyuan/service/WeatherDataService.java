package com.mao.heyuan.service;

import com.mao.heyuan.vo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
