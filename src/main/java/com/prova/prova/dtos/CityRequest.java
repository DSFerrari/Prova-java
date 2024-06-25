package com.prova.prova.dtos;

import jakarta.validation.constraints.NotNull;

public record CityRequest(
 @NotNull(message= "Nome não pode ser nulo")
 String nome,

 @NotNull(message= "Nome não pode ser nulo")
 String estado,
 @NotNull(message= "Nome não pode ser nulo")
 Integer população,
 @NotNull(message= "Nome não pode ser nulo")
 String pib
){}