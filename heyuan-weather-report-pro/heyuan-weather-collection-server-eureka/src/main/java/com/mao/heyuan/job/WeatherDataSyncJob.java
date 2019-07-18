package com.mao.heyuan.job;

import com.mao.heyuan.service.WeatherDataService;
import com.mao.heyuan.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start！");
        List<City> cityList = null;
        try {
            //TODO 改为由城市数据API微服务来提供城市列表的数据
            //获取xml中的城市ID列表
            //cityList=cityDataService.listCity();
            cityList=new ArrayList<>();
            City city=new City();
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exceptionxxx!", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);
            weatherDataService.syncDataByCityId(cityId);
        }
        logger.info("Weather Data Sync Job. End！");
    }
}
