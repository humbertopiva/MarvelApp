package com.example.marvelapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PersonagemNetwork {

    public static ArrayList<Personagem> buscarPersonagens(String url) throws IOException {
        ArrayList<Personagem> personagens = new ArrayList<>();
        //DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        OkHttpClient client = new OkHttpClient();

        Log.d("PersonagemNetwork.buscarFilmes:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject retorno = new JSONObject(json);
            System.out.println(retorno);
            JSONArray lista = retorno.getJSONArray("results");
            for(int i = 0; i < lista.length(); i++){
                Personagem personagem = new Personagem();
                JSONObject item = (JSONObject) lista.get(i);

                personagem.setId(item.getInt("id"));
                personagem.setTitulo(item.getString("title"));
                personagem.setDescricao(item.getString("overview"));
                personagem.setPosterPath(item.getString("poster_path"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return personagens;
    }

    public static Bitmap buscarImagens(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Bitmap img = null;

        Log.d("PersonagemNetwork.buscarImagens:url", url);
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnected();
    }

}
