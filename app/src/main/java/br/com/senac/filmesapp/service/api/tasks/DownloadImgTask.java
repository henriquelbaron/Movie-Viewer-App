package br.com.senac.filmesapp.service.api.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import br.com.senac.filmesapp.service.api.MovieDBAPIService;

public class DownloadImgTask extends AsyncTask<String, Void, Bitmap> {

    private Activity activity;
    private ProgressDialog load;

    public DownloadImgTask() {
        this.activity = null;
    }

    @Override
    protected Bitmap doInBackground(String... string) {
        if (string.length == 0 || string[0].trim().isEmpty()) {
            return null;
        }
        Bitmap bitmap = null;
        try {
            bitmap = MovieDBAPIService.getImagem(string[0]);
        } catch (IOException e) {
            Log.i("AsyncTask", e.getMessage());
        }
        return bitmap;
    }

    @Override
    protected void onPreExecute() {
//        load = ProgressDialog.show(activity, "Por favor Aguarde ...",
//                "Pesquisando Filmes ...");
    }

    @Override
    protected void onPostExecute(Bitmap param) {
//        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " +
//                Thread.currentThread().getName());
    }
}
