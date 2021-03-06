package com.mao.heyuan.controller;

import com.mao.heyuan.service.CityClient;
import com.mao.heyuan.service.DataClient;
import com.mao.heyuan.service.WeatherReportService;
import com.mao.heyuan.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
    @Autowired
    DataClient dataClient;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId")
    public ModelAndView getReportByCityId(String cityId, Model model) throws Exception {
        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {
            // TODO 改为由城市数据API微服务提供数据
            cityList=dataClient.listCity();

        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        model.addAttribute("title", "xiaomao天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
