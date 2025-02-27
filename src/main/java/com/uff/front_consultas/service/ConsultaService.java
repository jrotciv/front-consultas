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

import com.uff.front_consultas.dto.CriarConsultaDTO;
import com.uff.front_consultas.models.Consulta;

@Service
public class ConsultaService {

  public List<Consulta> listarConsultas(String token, String status) {
    RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    HttpEntity<Void> request = new HttpEntity<>(headers);

    // Ajusta a URL com o parâmetro de status
    ResponseEntity<Consulta[]> response = rt.exchange("http://localhost:8080/consultas?status=" + status, HttpMethod.GET, request, Consulta[].class);

    return Arrays.asList(response.getBody());
}

  public void criarConsulta(CriarConsultaDTO consulta, String token) {
    RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    HttpEntity<CriarConsultaDTO> request = new HttpEntity<>(consulta, headers);

    rt.postForEntity("http://localhost:8080/consultas", request, Void.class);
  }
}
