package br.com.senac.filmesapp.service.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.filmesapp.modal.domain.Genero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroDTO {
    private List<Genre> genres;

    public List<Genero> toObject() {
        List<Genero> generos = new ArrayList<>();
        for (Genre g : genres) {
            generos.add(new Genero(g.id, g.name));
        }
        return generos;
    }

    @Getter
    @Setter
    class Genre {
        private Integer id;
        private String name;
    }
}
