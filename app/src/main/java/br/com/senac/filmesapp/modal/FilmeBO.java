package br.com.senac.filmesapp.modal;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Collection;

import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.modal.domain.FilmeGenero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmeBO {

    private Integer id;
    private Double popularidade;
    private Double mediaVoto;
    private Integer totalVotos;
    private String titulo;
    private String tituloOriginal;
    private String linguagemOriginal;
    private String lancamento;
    private String img;
    private String descricao;
    private Collection<FilmeGenero> generos;
    private Bitmap imgBitmap;

    public FilmeBO(Integer id, Double popularidade, Double mediaVoto, Integer totalVotos, String titulo, String tituloOriginal, String linguagemOriginal, String lancamento, String img, String descricao) {
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
        this.generos = new ArrayList<>();
    }

    public Filme toFilme() {
        Filme filme = new Filme();
        filme.setId(id);
        filme.setDescricao(descricao);
        filme.setPopularidade(popularidade);
        filme.setMediaVoto(mediaVoto);
        filme.setTotalVotos(totalVotos);
        filme.setTitulo(titulo);
        filme.setTituloOriginal(tituloOriginal);
        filme.setLinguagemOriginal(linguagemOriginal);
        filme.setImg(img);
        filme.setLancamento(lancamento);
        filme.setGeneros(generos);
        return filme;
    }

    public void addGenero(FilmeGenero genero) {
        this.generos.add(genero);
    }
}
