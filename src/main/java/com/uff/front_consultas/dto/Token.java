package com.uff.front_consultas.dto;

public class Token {
  private String token;
  private String type;  

  public String getToken() {
    return token;
  }

  public String getType() { 
    return type;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setType(String type) {  
    this.type = type;
  }
}
