package br.com.senac.filmesapp.modal.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DatabaseTable(tableName = "genero")
public class Genero  implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;
    @DatabaseField
    private String genero;


    public Genero(Integer id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public Genero(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return genero;
    }
}
