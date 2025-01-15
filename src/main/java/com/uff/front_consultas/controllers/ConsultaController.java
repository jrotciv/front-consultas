package com.uff.front_consultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uff.front_consultas.models.Consulta;
import com.uff.front_consultas.service.ConsultaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/consultas")
public class ConsultaController {

  @Autowired
  private ConsultaService consultaService;

  @GetMapping("/listar")
  public String listarConsultas(HttpSession session, Model model) {
    String token = (String) session.getAttribute("token");
    if (token == null) {
        return "redirect:/usuario/login";
    }

    try {
        List<Consulta> consultas = consultaService.listarConsultas(token);
        model.addAttribute("consultas", consultas);
        return "consultas";
    } catch (Exception e) {
        model.addAttribute("erro", "Não foi possível listar as consultas.");
        return "erro";
    }
  }
  
}