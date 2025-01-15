package com.uff.front_consultas.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Paciente {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String contato;
    private LocalDate dataNascimento;
    private String convenio;
    private String nroConvenio;
}

