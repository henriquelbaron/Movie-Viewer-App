package br.com.senac.filmesapp.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.senac.filmesapp.R;
import br.com.senac.filmesapp.control.MainControl;
import br.com.senac.filmesapp.util.Utils;
import lombok.Getter;

@Getter
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText nome;
    private MainControl control;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiazer();
    }

    public void initialiazer() {
        listView = findViewById(R.id.listView);
        nome = findViewById(R.id.nomeFilme);
        control = new MainControl(this);
    }

    public void pesquisarFilme(View view) {
        control.pesquisarFilme(nome.getText().toString());
        Utils.hideSoftKeyboard(this);
    }

    public void favoritos(View view) {
        Intent intent = new Intent(this, FilmesFavoritos.class);
        this.startActivity(intent);
    }
}
