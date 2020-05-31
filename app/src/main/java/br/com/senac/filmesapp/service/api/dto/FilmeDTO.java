package br.com.senac.filmesapp.service.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.senac.filmesapp.activitys.MainActivity;
import br.com.senac.filmesapp.modal.domain.Filme;
import br.com.senac.filmesapp.service.api.tasks.DownloadImgTask;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeDTO {
    private float page;
    private float total_results;
    private float total_pages;
    private List<FilmeResult> results;


    public List<Filme> toObject() throws ExecutionException, InterruptedException {
        List<Filme> filmes = new ArrayList<>();
        for (FilmeResult f : results) {
            Filme filme = new Filme((long) f.getId(), Double.valueOf(f.popularity), Double.valueOf(f.vote_average), (int) f.vote_count, f.title, f.original_title, f.original_language, f.release_date, f.poster_path, f.overview);
            filmes.add(filme);
        }
        return filmes;
    }

    @Getter
    @Setter
    class FilmeResult {
        private float popularity;
        private float vote_count;
        private boolean video;
        private String poster_path;
        private float id;
        private boolean adult;
        private String backdrop_path;
        private String original_language;
        private String original_title;
        private String title;
        private float vote_average;
        private String overview;
        private String release_date;
    }
}
