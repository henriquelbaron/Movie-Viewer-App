package br.com.senac.filmesapp.service.api.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import br.com.senac.filmesapp.modal.domain.Genero;
import br.com.senac.filmesapp.service.api.MovieDBAPIService;
import br.com.senac.filmesapp.service.api.dto.GeneroDTO;

public class GeneroTask extends AsyncTask<Void, Void, List<Genero>> {

    private Activity activity;
    private ProgressDialog load;

    public GeneroTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        load = ProgressDialog.show(activity, "Por favor Aguarde ...",
                "Verificando Gêneros Disponiveis ...");
    }

    @Override
    protected List<Genero> doInBackground(Void... voids) {
        List<Genero> generos = null;
        try {
            GeneroDTO dto = MovieDBAPIService.getGeneros();
            generos = dto.toObject();
        } catch (IOException e) {
            Log.i("AsyncTask", e.getMessage());
        }
        return generos;
    }


    @Override
    protected void onPostExecute(List<Genero> generos) {
        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " +
                Thread.currentThread().getName());
        load.dismiss();
    }
}
