package com.uff.front_consultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uff.front_consultas.dto.CriarConsultaDTO;
import com.uff.front_consultas.models.Consulta;
import com.uff.front_consultas.service.ConsultaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/consultas")
public class ConsultaController {

  @Autowired
  private ConsultaService consultaService;

  @GetMapping("/listar")
  public String listarConsultas(@RequestParam(value = "status", defaultValue = "Pendente") String status, HttpSession session, Model model) {
    String token = (String) session.getAttribute("token");
    if (token == null) {
        return "redirect:/usuario/login";
    }

    try {
        List<Consulta> consultas = consultaService.listarConsultas(token, status);
        model.addAttribute("consultas", consultas);
        model.addAttribute("statusSelecionado", status);  
        return "consultas";
    } catch (Exception e) {
        model.addAttribute("erro", "Não foi possível listar as consultas.");
        return "erro";
    }
  }

  
  @PostMapping
  public String criarConsulta(@ModelAttribute CriarConsultaDTO  novaConsulta, HttpSession session, Model model) {
    String token = (String) session.getAttribute("token");
    if (token == null) {
        return "redirect:/usuario/login";
    }

    try {
        consultaService.criarConsulta(novaConsulta, token);
        return "redirect:/consultas/listar";
    } catch (Exception e) {
        model.addAttribute("erro", "Não foi possível criar a consulta.");
        return "erro";
    }
  }
}
