package br.com.senac.filmesapp.modal.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DatabaseTable(tableName = "filme_genero")
public class FilmeGenero implements Serializable {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Genero genero;


    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Filme filme;

    public FilmeGenero(Genero genero, Filme filme) {
        this.genero = genero;
        this.filme = filme;
    }
}
