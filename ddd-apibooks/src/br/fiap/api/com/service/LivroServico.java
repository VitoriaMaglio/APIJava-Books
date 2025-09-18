package br.fiap.api.com.service;

import br.fiap.api.com.model.Livro;
import br.fiap.api.com.model.OpenLibraryResponse;
import com.google.gson.Gson;
import netscape.javascript.JSObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
//Vitória Valentina Maglio rm563509
//Felipe Maglio filho rm563512
public class LivroServico {

    //Para consumir a API do Open Library e transformar o JSON em obj Java, usamos GSON
    //Classe da API é responsável por mapear a estrutura da resposta Json para facilitar a conversão,
    // já que API não retorna só um livro, retorna objeto com vários campos em lista (docs), porém só queremos os campos representados
    //pelos atributos, então vamos ler o json como objeto, passar para lista em objeto java e salvar no arq json como objeto json.

    public List<Livro> buscarLivro(String nome){
        try{
            String url = "https://openlibrary.org/search.json?q=" + nome.replace(" ", "+");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            OpenLibraryResponse resultado = gson.fromJson(response.body(), OpenLibraryResponse.class);
            return resultado.getDocs();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
