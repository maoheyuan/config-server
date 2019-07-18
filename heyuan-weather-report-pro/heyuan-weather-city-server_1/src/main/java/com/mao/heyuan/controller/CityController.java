package com.mao.heyuan.controller;

import com.mao.heyuan.service.CityDataService;
import com.mao.heyuan.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/listCity")
    public List<City> getCityList() throws Exception {
        return cityDataService.listCity();
    }
}
