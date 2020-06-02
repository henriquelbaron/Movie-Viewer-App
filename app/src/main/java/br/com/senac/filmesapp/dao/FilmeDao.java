package br.com.senac.filmesapp.dao;

import android.content.Context;

import br.com.senac.filmesapp.dao.helpers.DaoHelper;
import br.com.senac.filmesapp.modal.domain.Filme;

public class FilmeDao extends DaoHelper<Filme> {
    public FilmeDao(Context c) {
        super(c, Filme.class);
    }
}
