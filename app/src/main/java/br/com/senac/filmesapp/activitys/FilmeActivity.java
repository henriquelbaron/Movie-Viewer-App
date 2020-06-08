package br.com.senac.filmesapp.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.senac.filmesapp.R;
import br.com.senac.filmesapp.control.FilmeControl;
import br.com.senac.filmesapp.modal.FilmeBO;
import lombok.Getter;

@Getter
public class FilmeActivity extends AppCompatActivity {

    private FilmeBO filmeBO;
    private TextView titulo, tituloOriginal, popularidade, votos_qtd, media,lancamento,linguagem_original,descricao;
    private ImageView post;
    private FilmeControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);
        Intent it = getIntent();
        filmeBO = it.getParcelableExtra("filmeBO");
        byte[] bytes = getIntent().getByteArrayExtra("bitmapbytes");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        post = findViewById(R.id.imagem);
        post.setImageBitmap(bmp);
        descricao = findViewById(R.id.descricao);
        titulo = findViewById(R.id.filmeNome);
        tituloOriginal = findViewById(R.id.titulo_original);
        popularidade = findViewById(R.id.popularidade);
        votos_qtd = findViewById(R.id.votos_qtd);
        media = findViewById(R.id.media);
        lancamento = findViewById(R.id.lancamento);
        linguagem_original = findViewById(R.id.linguagem_original);

        control = new FilmeControl(this);
    }
}