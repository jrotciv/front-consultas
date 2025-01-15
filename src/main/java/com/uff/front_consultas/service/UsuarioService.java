package com.uff.front_consultas.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uff.front_consultas.dto.Token;

@Service
public class UsuarioService {

  public Token login(String email, String senha) {
    RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, String> data = new HashMap<>();
    data.put("email", email);
    data.put("senha", senha);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

    var result = rt.postForObject("http://localhost:8080/usuarios/login", request, Token.class);
    
    return result;
  }
}
