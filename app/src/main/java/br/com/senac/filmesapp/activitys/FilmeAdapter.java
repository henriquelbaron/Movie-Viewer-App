package br.com.senac.filmesapp.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.senac.filmesapp.R;
import br.com.senac.filmesapp.modal.domain.Filme;

public class FilmeAdapter extends BaseAdapter {

    private Context context;
    private List<Filme> arrayList;
    private TextView titulo, descricao;
    private ImageView image;

    public FilmeAdapter(Context context, List<Filme> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void updateReceiptsList(List<Filme> newlist) {
        arrayList.clear();
        arrayList.addAll(newlist);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        titulo = convertView.findViewById(R.id.title);
        descricao = convertView.findViewById(R.id.descricao);
        image = convertView.findViewById(R.id.imagem);
        titulo.setText(arrayList.get(position).getTitulo());
        descricao.setText(arrayList.get(position).getDescricao());
        image.setImageBitmap(arrayList.get(position).getImagBitmap());
        return convertView;
    }
}
