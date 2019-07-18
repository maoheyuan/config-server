package com.mao.heyuan.Controller;

import com.mao.heyuan.service.CityClient;
import com.mao.heyuan.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityClient  cityClient;

    @GetMapping("/cities")
    public List<City> listCity() throws Exception{
        List<City> cityList=cityClient.listCity();
        return cityList;
    }
}
