package br.fiap.api.com.model;

public class Livro {
    //atributos
    private String nome;
    private String autor;
    private String idioma;
    private String editora;

    //construtor

    public Livro() {
    }

    public Livro(String nome, String autor, String idioma, String editora) {
        this.nome = nome;
        this.autor = autor;
        this.idioma = idioma;
        this.editora = editora;
    }
    //getters e setters

    public String getNome() {
        return nome;}

    public void setNome(String nome) {
        this.nome = nome;}

    public String getAutor() {
        return autor;}

    public void setAutor(String autor) {
        this.autor = autor;}

    public String getIdioma() {
        return idioma;}

    public void setIdioma(String idioma) {
        this.idioma = idioma;}

    public String getEditora() {
        return editora;}

    public void setEditora(String editora) {
        this.editora = editora;}
}
