package com.uff.front_consultas.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class Consulta {
    private Long id;
    private LocalDate data;
    private LocalTime horario;
    private String status;
    private List<String> sintomas;
    private List<String> diagnostico;
    private List<String> observacoes;
    private LocalDate criadaEm;
    private Medico medico;
    private Paciente paciente;
}
