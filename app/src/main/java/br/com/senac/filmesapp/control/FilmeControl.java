package br.com.senac.filmesapp.control;

import br.com.senac.filmesapp.activitys.FilmeActivity;
import br.com.senac.filmesapp.modal.FilmeBO;
import br.com.senac.filmesapp.util.Utils;

public class FilmeControl {
    private FilmeActivity activity;
    private FilmeBO filme;

    public FilmeControl(FilmeActivity activity) {
        this.activity = activity;
        filme = activity.getFilmeBO();
        popularForm();
    }

    private void popularForm() {
        activity.getDescricao().setText(filme.getDescricao());
        activity.getMedia().setText(Utils.formatDouble(filme.getMediaVoto()));
        activity.getLancamento().setText(filme.getLancamento());
        activity.getPopularidade().setText(Utils.formatDouble(filme.getPopularidade()));
        activity.getVotos_qtd().setText(filme.getTotalVotos().toString());
        activity.getTitulo().setText(filme.getTitulo());
        activity.getTituloOriginal().setText(filme.getTituloOriginal());
        activity.getLinguagem_original().setText(filme.getLinguagemOriginal());
    }
}
