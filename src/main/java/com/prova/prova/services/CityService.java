package com.prova.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.prova.dtos.CityRequest;
import com.prova.prova.dtos.CityResponse;
import com.prova.prova.entities.Cidade;
import com.prova.prova.mappers.CityMapper;
import com.prova.prova.repositories.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public List<CityResponse> getCities() {
        List<Cidade> cidades = cityRepository.findAll();

        return cidades.stream()
                    .map(c -> CityMapper.toDTO(c))
                    .collect(Collectors.toList());
    }
    public CityResponse getCityById(int id) {
        Cidade city = cityRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não cadastrada"));
            return CityMapper.toDTO(city);
    }

    public CityResponse saveCity(CityRequest request){
        Cidade cidade = CityMapper.toEntity(request);

        return CityMapper.toDTO(this.cityRepository.save(cidade));
    }

    public void updateCity(int id, CityRequest request){
        try{
            Cidade aux = cityRepository.getReferenceById(id);
            aux.setNome(request.nome());
            aux.setEstado(request.estado());
            aux.setPopulação(request.população());
            aux.setPib(request.pib());
            this.cityRepository.save(aux);
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Cidade não cadastrada");
        }
        }

        public void deleteCityById(int id) {
            if (this.cityRepository.existsById(id)) {
            this.cityRepository.deleteById(id);
            }
            else {
            throw new EntityNotFoundException("Cidade não cadastrada");
            }
            }
    }
