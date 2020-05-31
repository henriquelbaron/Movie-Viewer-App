package br.com.senac.filmesapp.service.api.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import br.com.senac.filmesapp.service.api.MovieDBAPIService;

public class SessionTask extends AsyncTask<Void, Void, Void> {

    private Activity activity;
    private ProgressDialog load;

    public SessionTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        load = ProgressDialog.show(activity, "Por favor Aguarde ...",
                "Criando sessão ...");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            MovieDBAPIService.createSession();
        } catch (IOException e) {
            Log.i("AsyncTask", e.getMessage());
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void voids) {
        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " +
                Thread.currentThread().getName());
        load.dismiss();
    }
}
