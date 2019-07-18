package com.mao.heyuan.service;

import com.mao.heyuan.vo.Weather;

public interface WeatherReportService {
    public Weather getDataByCityId(String cityId);
}
