package br.com.senac.filmesapp.service.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
    private boolean success;
    private String expires_at;
    private String request_token;
}
