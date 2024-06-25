package com.prova.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.prova.dtos.CityRequest;
import com.prova.prova.dtos.CityResponse;
import com.prova.prova.services.CityService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService cityService;

@GetMapping
public List<CityResponse> getCities(){
    return cityService.getCities();
}

@GetMapping("{id}")
public CityResponse getCityById(@PathVariable int id){
    return cityService.getCityById(id);
}

@PutMapping("{id}")
public void updateCity(@PathVariable int id, @RequestBody CityRequest cidade ){

    this.cityService.updateCity(id, cidade);
    }
@DeleteMapping("{id}")
 public void deleteCityById(@PathVariable int id) {
 this.cityService.deleteCityById(id);
 }
}
