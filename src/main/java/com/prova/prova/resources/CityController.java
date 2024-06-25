package com.prova.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public ResponseEntity<List<CityResponse>> getCities(){
    return ResponseEntity.ok(cityService.getCities());
}

@GetMapping("{id}")
public ResponseEntity<CityResponse>getCityById(@PathVariable int id){
    return ResponseEntity.ok( cityService.getCityById(id));
}

@PutMapping("{id}")
public ResponseEntity<Void> updateCity(@Validated @PathVariable int id, @RequestBody CityRequest cidade ){
    this.cityService.updateCity(id, cidade);
    return ResponseEntity.ok().build();   
}
@DeleteMapping("{id}")
 public ResponseEntity<Void> deleteCityById(@PathVariable int id) {
 this.cityService.deleteCityById(id);
 return ResponseEntity.noContent().build();
 }
}
