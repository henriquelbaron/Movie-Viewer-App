package br.com.senac.filmesapp.modal.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Genero {

    private Integer id;
    private String genero;

    public Genero(Integer id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
