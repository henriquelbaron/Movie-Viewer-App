package br.com.senac.filmesapp.modal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import br.com.senac.filmesapp.modal.domain.Filme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmeBO implements Parcelable {

    public static final Parcelable.Creator<FilmeBO> CREATOR = new Parcelable.Creator<FilmeBO>() {
        public FilmeBO createFromParcel(Parcel parcel) {
            return new FilmeBO(parcel);
        }

        public FilmeBO[] newArray(int size) {
            return new FilmeBO[size];
        }
    };

    private Integer id;
    private Double popularidade;
    private Double mediaVoto;
    private Integer totalVotos;
    private String titulo;
    private String tituloOriginal;
    private String linguagemOriginal;
    private String lancamento;
    private String img;
    private String descricao;
    //    private Collection<Genero> generos;
    private Bitmap imgBitmap;

    public FilmeBO(Filme f) {
        this.id = f.getId();
        this.popularidade = f.getPopularidade();
        this.mediaVoto = f.getMediaVoto();
        this.totalVotos = f.getTotalVotos();
        this.titulo = f.getTitulo();
        this.tituloOriginal = f.getTituloOriginal();
        this.linguagemOriginal = f.getLinguagemOriginal();
        this.lancamento = f.getLancamento();
        this.img = f.getImg();
        this.descricao = f.getDescricao();
    }

    public FilmeBO(Integer id, Double popularidade, Double mediaVoto, Integer totalVotos, String titulo, String tituloOriginal, String linguagemOriginal, String lancamento, String img, String descricao) {
        this.id = id;
        this.popularidade = popularidade;
        this.mediaVoto = mediaVoto;
        this.totalVotos = totalVotos;
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.linguagemOriginal = linguagemOriginal;
        this.lancamento = lancamento;
        this.img = img;
        this.descricao = descricao;
//        this.generos = new ArrayList<>();
    }

    public FilmeBO(Parcel p) {
        this.id = p.readInt();
        this.popularidade = p.readDouble();
        this.mediaVoto = p.readDouble();
        this.totalVotos = p.readInt();
        this.titulo = p.readString();
        this.tituloOriginal = p.readString();
        this.linguagemOriginal = p.readString();
        this.lancamento = p.readString();
        this.img = p.readString();
        this.descricao = p.readString();
    }

    public Filme toFilme() {
        Filme filme = new Filme();
        filme.setId(id);
        filme.setDescricao(descricao);
        filme.setPopularidade(popularidade);
        filme.setMediaVoto(mediaVoto);
        filme.setTotalVotos(totalVotos);
        filme.setTitulo(titulo);
        filme.setTituloOriginal(tituloOriginal);
        filme.setLinguagemOriginal(linguagemOriginal);
        filme.setImg(img);
        filme.setLancamento(lancamento);
//        filme.setGeneros(generos);
        return filme;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(popularidade);
        dest.writeDouble(mediaVoto);
        dest.writeInt(totalVotos);
        dest.writeString(titulo);
        dest.writeString(tituloOriginal);
        dest.writeString(linguagemOriginal);
        dest.writeString(lancamento);
        dest.writeString(img);
        dest.writeString(descricao);
    }
//    public void addGenero(Genero genero) {
//        this.generos.add(genero);
//    }
}
