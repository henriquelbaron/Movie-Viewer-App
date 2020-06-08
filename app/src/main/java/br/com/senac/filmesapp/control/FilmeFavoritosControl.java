package br.com.senac.filmesapp.control;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.senac.filmesapp.activitys.FilmeActivity;
import br.com.senac.filmesapp.activitys.FilmeAdapter;
import br.com.senac.filmesapp.activitys.FilmesFavoritos;
import br.com.senac.filmesapp.dao.FilmeDao;
import br.com.senac.filmesapp.modal.FilmeBO;
import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.service.api.tasks.DownloadImgTask;
import br.com.senac.filmesapp.service.api.tasks.SessionTask;

public class FilmeFavoritosControl {

    private FilmesFavoritos activity;
    private FilmeAdapter filmeAdapter;
    private List<FilmeBO> filmeBOS;
    private FilmeDao filmeDao;
    private FilmeBO filmeBO;

    public FilmeFavoritosControl(FilmesFavoritos activity) {
        this.activity = activity;
        configView();
    }

    private void configView() {
        filmeDao = new FilmeDao(activity);
        DownloadImgTask downloadImgTask = new DownloadImgTask(activity);
        try {
            List<Filme> filmes = filmeDao.getDao().queryForAll();
            filmeBOS = downloadImgTask.execute(filmes).get();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        filmeAdapter = new FilmeAdapter(activity, filmeBOS);
        activity.getFilmeList().setAdapter(filmeAdapter);
        addCliqueCurtoListView();
        addCliqueLongoListView();
    }

    private void addCliqueCurtoListView() {
        activity.getFilmeList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final FilmeBO filme = filmeAdapter.getItem(position);
                detalhesDoFilme(filme);
            }
        });
    }

    private void addCliqueLongoListView() {
        activity.getFilmeList().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                filmeBO = filmeAdapter.getItem(position);
                confirmarExclusaoAction(filmeBO);
                return true;
            }
        });
    }

    private void confirmarExclusaoAction(final FilmeBO f) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Retirar Filme");
        alerta.setMessage("Deseja retirar " + f.getTitulo() + " da sua Lista de Favoritos?");
        alerta.setIcon(android.R.drawable.ic_delete);
        alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                filmeBO = null;
            }
        });
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deletaPedido(f);
            }
        });
        alerta.show();
    }

    private void deletaPedido(final FilmeBO f) {
        try {
            filmeDao.getDao().delete(f.toFilme());
            filmeBOS.remove(f);
            filmeAdapter.notifyDataSetChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void detalhesDoFilme(FilmeBO filme) {
        Intent intent = new Intent(activity, FilmeActivity.class);
        Bitmap bitmap = filme.getImgBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bytes = stream.toByteArray();
        intent.putExtra("bitmapbytes",bytes);
        intent.putExtra("filmeBO", filme);
        activity.startActivity(intent);
    }

}
