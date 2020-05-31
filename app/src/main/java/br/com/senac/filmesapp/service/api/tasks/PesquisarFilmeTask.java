package br.com.senac.filmesapp.service.api.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.service.api.MovieDBAPIService;
import br.com.senac.filmesapp.service.api.dto.FilmeDTO;

public class PesquisarFilmeTask extends AsyncTask<String, Integer, List<Filme>> {

    private Activity activity;
    private ProgressDialog load;

    public PesquisarFilmeTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected List<Filme> doInBackground(String... string) {
        if (string.length == 0 || string[0].trim().isEmpty()) {
            return null;
        }
        List<Filme> filmes = null;
        try {
            FilmeDTO dto = MovieDBAPIService.getFilmesPorNome(string[0]);
            filmes = dto.toObject();
            int counter = 0;
            for (Filme f : filmes) {
                f.setImagBitmap(MovieDBAPIService.getImagem(f.getImg()));
                counter++;

                publishProgress(counter * 100 / filmes.size());
            }
        } catch (IOException e) {
            Log.i("AsyncTask", e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    @Override
    protected void onPreExecute() {
        load = new ProgressDialog(activity);
        load.setCancelable(true);
        load.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        load.setMax(100);
        load.setMessage("Procurando filmes ...");
        load.show();
    }

    @Override
    protected void onPostExecute(List<Filme> param) {
        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " +
                Thread.currentThread().getName());
        load.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        load.setProgress(values[0]);
    }
}
