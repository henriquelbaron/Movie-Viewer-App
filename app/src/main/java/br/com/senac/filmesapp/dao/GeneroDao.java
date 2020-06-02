package br.com.senac.filmesapp.dao;

import android.content.Context;

import br.com.senac.filmesapp.dao.helpers.DaoHelper;
import br.com.senac.filmesapp.modal.domain.Genero;

public class GeneroDao extends DaoHelper<Genero> {
    public GeneroDao(Context c) {
        super(c, Genero.class);
    }
}
