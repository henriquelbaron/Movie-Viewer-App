package br.com.senac.filmesapp.service.api.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.filmesapp.modal.FilmeBO;
import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.service.api.MovieDBAPIService;

public class DownloadImgTask extends AsyncTask<List<Filme>, Void, List<FilmeBO>> {

    private Activity activity;
    private ProgressDialog load;

    public DownloadImgTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected List<FilmeBO> doInBackground(List<Filme>... list) {
        if (list.length == 0) {
            return null;
        }
        List<FilmeBO> filmeBOS = new ArrayList<>();
        for (Filme f : list[0]) {
            FilmeBO filmeBO = new FilmeBO(f);
            try {
                filmeBO.setImgBitmap(MovieDBAPIService.getImagem(f.getImg()));
                filmeBOS.add(filmeBO);
            } catch (IOException e) {
                Log.i("AsyncTask", e.getMessage());
            }
        }
        return filmeBOS;
    }

    @Override
    protected void onPreExecute() {
//        load = ProgressDialog.show(activity, "Por favor Aguarde ...",
//                "Pesquisando Filmes ...");
    }

    @Override
    protected void onPostExecute(List<FilmeBO> param) {
//        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " +
//                Thread.currentThread().getName());
    }
}
