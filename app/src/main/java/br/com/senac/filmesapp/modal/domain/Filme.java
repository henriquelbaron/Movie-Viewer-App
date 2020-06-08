package br.com.senac.filmesapp.modal.domain;

import android.graphics.Bitmap;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DatabaseTable(tableName = "filme")
public class Filme implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;
    @DatabaseField
    private Double popularidade;
    @DatabaseField
    private Double mediaVoto;
    @DatabaseField
    private Integer totalVotos;
    @DatabaseField(canBeNull = false)
    private String titulo;
    @DatabaseField
    private String tituloOriginal;
    @DatabaseField
    private String linguagemOriginal;
    @DatabaseField
    private String lancamento;
    @DatabaseField
    private String img;
    @DatabaseField
    private String descricao;

//    @ForeignCollectionField
//    private Collection<Genero> generos;

    public Filme(Integer id, Double popularidade, Double mediaVoto, Integer totalVotos, String titulo, String tituloOriginal, String linguagemOriginal, String lancamento, String img, String descricao) {
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
//        this.generos = new ArrayList<>();
    }

//    public void addGenero(Genero genero){
//        this.generos.add(genero);
//    }
}
