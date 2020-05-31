package br.com.senac.filmesapp.modal.domain;

import android.graphics.Bitmap;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Filme {

    private Long id;
    private Double popularidade;
    private Double mediaVoto;
    private Integer totalVotos;
    private String titulo;
    private String tituloOriginal;
    private String linguagemOriginal;
    private String lancamento;
    private String img;
    private Bitmap imagBitmap;
    private String descricao;
    private List<Genero> generos;

    public Filme(Long id, Double popularidade, Double mediaVoto, Integer totalVotos, String titulo, String tituloOriginal, String linguagemOriginal, String lancamento, String img, String descricao) {
        this.id = id;
        this.popularidade = popularidade;
        this.mediaVoto = mediaVoto;
        this.totalVotos = totalVotos;
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.linguagemOriginal = linguagemOriginal;
        this.lancamento = lancamento;
        this.img = img;
        this.descricao = descricao;
    }
}
