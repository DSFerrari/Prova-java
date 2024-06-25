package com.prova.prova.mappers;

import com.prova.prova.dtos.CityRequest;
import com.prova.prova.dtos.CityResponse;
import com.prova.prova.entities.Cidade;

public class CityMapper {
    public static Cidade toEntity(CityRequest request) {
        Cidade city = new Cidade();
        city.setNome(request.nome());
        city.setEstado(request.estado());
        city.setPopulação(request.população());
        city.setPib(request.pib());
        return city;
    }

    public static CityResponse toDTO(Cidade city) {
        return new CityResponse(city.getId(), city.getNome(), city.getEstado(),city.getPopulação(),city.getPib());

        }
    }
