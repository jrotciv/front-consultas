package com.uff.front_consultas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uff.front_consultas.service.UsuarioService;

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
  public String signIn(String email, String senha) {
    this.usuarioService.login(email, senha);
    return "redirect:login";
  }
}
