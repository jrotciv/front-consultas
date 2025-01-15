package com.uff.front_consultas.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroUsuarioDTO {
  private String cpf;
  private String nome;
  private String email;
  private String senha;
  private String contato;
  private LocalDate dataNascimento;

  //Medico
  private String crm;
  private String especialidade;

  //Paciente
  private String convenio;
  private String nroConvenio;
}
