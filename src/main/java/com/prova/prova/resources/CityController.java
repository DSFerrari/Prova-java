package com.prova.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.prova.dtos.CityResponse;
import com.prova.prova.services.CityService;

@RestController
@RequestMapping("Cities")
public class CityController {
    @Autowired
    private CityService cityService;

@GetMapping
public List<CityResponse> getCities(){
    return cityService.getCities();
}
}
