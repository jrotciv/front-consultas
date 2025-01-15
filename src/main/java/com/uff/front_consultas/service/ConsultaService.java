package com.uff.front_consultas.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uff.front_consultas.models.Consulta;

@Service
public class ConsultaService {

  public List<Consulta> listarConsultas(String token) {
    RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    HttpEntity<Void> request = new HttpEntity<>(headers);

    ResponseEntity<Consulta[]> response = rt.exchange("http://localhost:8080/consultas?status=Pendente", HttpMethod.GET, request, Consulta[].class);

    return Arrays.asList(response.getBody());
  }
}
