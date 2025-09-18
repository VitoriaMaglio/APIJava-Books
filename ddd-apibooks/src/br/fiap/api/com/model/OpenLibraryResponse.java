package br.fiap.api.com.model;

import java.util.List;
//Vitória Valentina Maglio rm563509
//Felipe Maglio filho rm563512
public class OpenLibraryResponse {
    //A Open Library API retorna informações sobre o livro (como informações do autor, ano da primeira publicação, idioma, etc.),
    // tem formato de resposta como JSON.
    //Os campos da API são do tipo arrays(listas), então ao declarar atributos do objeto real que estamos representando em Java, devemos declarar como listas.

    private List<Livro> docs; // a API retorna os livros dentro de "docs"

    // Getter e Setter
    public List<Livro> getDocs() {
        return docs;
    }

    public void setDocs(List<Livro> docs) {
        this.docs = docs;
    }
}
