package br.com.senac.filmesapp.control;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.senac.filmesapp.activitys.FilmeAdapter;
import br.com.senac.filmesapp.activitys.MainActivity;
import br.com.senac.filmesapp.dao.FilmeDao;
import br.com.senac.filmesapp.dao.GeneroDao;
import br.com.senac.filmesapp.modal.FilmeBO;
import br.com.senac.filmesapp.modal.domain.Genero;
import br.com.senac.filmesapp.service.api.tasks.GeneroTask;
import br.com.senac.filmesapp.service.api.tasks.PesquisarFilmeTask;
import br.com.senac.filmesapp.service.api.tasks.SessionTask;

public class MainControl {

    private MainActivity activity;
    private FilmeAdapter filmeAdapter;
    private List<FilmeBO> filmes;
    private FilmeDao filmeDao;
    private GeneroDao generoDao;

    public MainControl(MainActivity activity) {
        this.activity = activity;
        new SessionTask(activity).execute();
        configView();
    }

    private void configView() {
        generoDao = new GeneroDao(activity);
        try {
            List<Genero> generos = new GeneroTask(activity).execute().get();
            for (Genero g : generos) {
                generoDao.getDao().createIfNotExists(g);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filmeDao = new FilmeDao(activity);
        filmes = new ArrayList<>();
        filmeAdapter = new FilmeAdapter(activity, filmes);
        activity.getListView().setAdapter(filmeAdapter);
        addCliqueCurtoListView();
    }


    public void pesquisarFilme(String filme) {
        try {
            PesquisarFilmeTask pesquisarFilmeTask = new PesquisarFilmeTask(activity);
            pesquisarFilmeTask.execute(filme);
            filmes = pesquisarFilmeTask.get();
            filmeAdapter.updateReceiptsList(filmes);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addCliqueCurtoListView() {
        activity.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final FilmeBO filme = filmeAdapter.getItem(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setMessage("Deseja adicionar " + filme.getTitulo() + " Favoritos?");
                alerta.setIcon(android.R.drawable.ic_input_add);
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        salvar(filme);
                    }
                });
                alerta.setNeutralButton("Fechar", null);
                alerta.show();
            }
        });
    }

    private void salvar(FilmeBO filme) {
        try {
            filmeDao.getDao().queryForId(filme.getId());
            filmeDao.getDao().createIfNotExists(filme.toFilme());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
