package br.fiap.api.com.model;

import java.util.List;
//Vitória Valentina Maglio rm563509
//Felipe Maglio filho rm563512
public class Livro {
    //atributos
    private String title;
    private List<String> author_name;
    private List<String> language;
    private List<String> publisher;

    // Construtor vazio
    public Livro() {}
    // Construtor com parâmetros
    public Livro(String title, List<String> author_name, List<String> language, List<String> publisher) {
        this.title = title;
        this.author_name = author_name;
        this.language = language;
        this.publisher = publisher;
    }
    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<String> getAuthor_name() { return author_name; }
    public void setAuthor_name(List<String> author_name) { this.author_name = author_name; }

    public List<String> getLanguage() { return language; }
    public void setLanguage(List<String> language) { this.language = language; }

    public List<String> getPublisher() { return publisher; }
    public void setPublisher(List<String> publisher) { this.publisher = publisher; }

    @Override
    public String toString() {
        return "Livro:" +
                "nome='" + title + '\'' +
                ", autor=" + author_name +
                ", idioma=" + language +
                ", editora=" + publisher +
                '}';
    }
}
