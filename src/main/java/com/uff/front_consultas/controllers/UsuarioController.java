package com.uff.front_consultas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uff.front_consultas.dto.CadastroUsuarioDTO;
import com.uff.front_consultas.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;
  
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/signIn")
  public String signIn(String email, String senha, HttpSession session) {
    var token = this.usuarioService.login(email, senha);

    if (token != null) {
      session.setAttribute("token", token.getToken());
      session.setAttribute("tipo_usuario", token.getType());
      return "redirect:/consultas/listar";
    }
    return "redirect:login";
  }

  @GetMapping("/cadastro")
  public String cadastro() {
    return "cadastroUsuario";
  }

  @PostMapping("/cadastrar")
  public String criarUsuario(CadastroUsuarioDTO usuario) {
    try {
      this.usuarioService.criarUsuario(usuario);
      System.out.println("Cadastro realizado com sucesso!");
      return "redirect:/usuario/login";
    } catch (Exception e) {
      e.printStackTrace(); 
      return "redirect:/usuario/cadastro";
    }
  }
}
