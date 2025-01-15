package com.uff.front_consultas.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarConsultaDTO {
  @JsonProperty("medico_cpf")
  private String medicoCpf;
  @JsonProperty("paciente_cpf")
  private String pacienteCpf;
  private LocalDate data;
  private LocalTime horario;
}
