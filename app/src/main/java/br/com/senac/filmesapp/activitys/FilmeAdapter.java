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
import br.com.senac.filmesapp.modal.FilmeBO;
import br.com.senac.filmesapp.modal.domain.Filme;

public class FilmeAdapter extends BaseAdapter {

    private Context context;
    private List<FilmeBO> arrayList;
    private TextView titulo, descricao;
    private ImageView image;

    public FilmeAdapter(Context context, List<FilmeBO> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void updateReceiptsList(List<FilmeBO> newlist) {
        arrayList.clear();
        arrayList.addAll(newlist);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public FilmeBO getItem(int position) {
        return arrayList.get(position);
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
        String desc = arrayList.get(position).getDescricao();
        if (desc.length() > 300){
            desc = desc.substring(0,300) + " ...";
        }
        descricao.setText(desc);
        image.setImageBitmap(arrayList.get(position).getImgBitmap());
        return convertView;
    }
}
