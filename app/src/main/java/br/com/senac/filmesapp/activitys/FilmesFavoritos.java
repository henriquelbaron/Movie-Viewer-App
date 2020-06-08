package br.com.senac.filmesapp.activitys;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.senac.filmesapp.R;
import br.com.senac.filmesapp.control.FilmeFavoritosControl;
import lombok.Getter;

@Getter
public class FilmesFavoritos extends AppCompatActivity {

    private ListView filmeList;
    private FilmeFavoritosControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes_favoritos);
        filmeList = findViewById(R.id.filmeFavoritos);
        control = new FilmeFavoritosControl(this);
    }
}