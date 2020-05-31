package br.com.senac.filmesapp.control;

import android.app.ProgressDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.senac.filmesapp.activitys.FilmeAdapter;
import br.com.senac.filmesapp.activitys.MainActivity;
import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.service.api.tasks.PesquisarFilmeTask;
import br.com.senac.filmesapp.service.api.tasks.SessionTask;

public class MainControl {

    private MainActivity activity;
    private FilmeAdapter filmeAdapter;
    private List<Filme> filmes;

    public MainControl(MainActivity activity) {
        this.activity = activity;
        new SessionTask(activity).execute();
        configView();
    }

    private void configView() {
        filmes = new ArrayList<>();
        filmeAdapter = new FilmeAdapter(activity, filmes);
        activity.getListView().setAdapter(filmeAdapter);
    }


    public void pesquisarFilme(String filme) {
        try {
             PesquisarFilmeTask pesquisarFilmeTask = new PesquisarFilmeTask(activity);
             pesquisarFilmeTask.execute(filme);
            filmes =pesquisarFilmeTask.get();
            filmeAdapter.updateReceiptsList(filmes);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
