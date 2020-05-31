package br.com.senac.filmesapp.service.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import br.com.senac.filmesapp.exeptions.ProblemaAoValidarSessao;
import br.com.senac.filmesapp.service.api.dto.FilmeDTO;
import br.com.senac.filmesapp.service.api.dto.GeneroDTO;
import br.com.senac.filmesapp.service.api.dto.Token;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MovieDBAPIService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String LANGUAGE = "language=" + Locale.getDefault().toLanguageTag();
    public static final String KEY = "api_key=dbe22af6dc83d56fa35826bd8cddd9aa";
    private static final String URL_IMAGES = "https://image.tmdb.org/t/p/w500/";
    private static String TOKEN;

    private static ResponseBody executeRequest(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }

    private static ResponseBody executePostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }

    public static Bitmap getImagem(String src) throws IOException {
        String url = URL_IMAGES +src;
        Bitmap bitmap = BitmapFactory.decodeStream(executeRequest(url).byteStream());
        return bitmap;
    }
    public static FilmeDTO getRankFilmesPorGenero(String genero) throws IOException {
        String url = "https://api.themoviedb.org/3/discover/movie?" + KEY + "&" + LANGUAGE + "&sort_by=popularity.desc&include_adult=true&include_video=false&page=1&with_genres=" + genero;
        Gson gson = new Gson();
        FilmeDTO dto = gson.fromJson(executeRequest(url).string(), FilmeDTO.class);
        return dto;
    }

    public static FilmeDTO getFilmesPorNome(String nome) throws IOException {
        String url = "https://api.themoviedb.org/3/search/movie?" + KEY + "&" + LANGUAGE + "&query=" + nome;
        Gson gson = new Gson();
        FilmeDTO dto = gson.fromJson(executeRequest(url).string(), FilmeDTO.class);
        return dto;
    }

    public static GeneroDTO getGeneros() throws IOException {
        String url = "https://api.themoviedb.org/3/genre/movie/list?" + KEY + "&" + LANGUAGE;
        Gson gson = new Gson();
        GeneroDTO dto = gson.fromJson(executeRequest(url).string(), GeneroDTO.class);
        return dto;
    }

    public static Token getToken() throws IOException {
        String url = "https://api.themoviedb.org/3/authentication/token/new?" + KEY;
        Gson gson = new Gson();
        Token dto = gson.fromJson(executeRequest(url).string(), Token.class);
        return dto;
    }

    public static Boolean createSession() throws IOException {
        String url = "https://api.themoviedb.org/3/authentication/token/validate_with_login?" + KEY;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "hike.baron");
            jsonObject.put("password", "wc8y@Rqq2hKAceE");
            jsonObject.put("request_token", getToken().getRequest_token());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Token dto = gson.fromJson(executePostRequest(url, jsonObject.toString()).string(), Token.class);
        if (dto.isSuccess()) {
            TOKEN = dto.getRequest_token();
            return true;
        } else {
            throw new ProblemaAoValidarSessao("Problemas ao Validar Token, Entre em contato com o Desenvolvedor");
        }
    }
}
