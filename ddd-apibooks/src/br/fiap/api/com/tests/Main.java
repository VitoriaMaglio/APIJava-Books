package br.fiap.api.com.tests;

import br.fiap.api.com.model.Livro;
import br.fiap.api.com.service.LivroServico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Vitória Valentina Maglio rm563509
//Felipe Maglio filho rm563512
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        LivroServico livroServico = new LivroServico();
        System.out.println("Digite o nome do livro que você deseja buscar na API Pública Open Library: ");
        String resp = leitor.nextLine();
        List<Livro> livros = livroServico.buscarLivro(resp); //chamando o serviço que vai buscar o livro

        // criar o arquivo com informações e imprimir no terminal
        //Quando rodamos a main deu erro null em editora, porque algum livros não tem registro de editora na api, então só aparece o livro se ele não tiver campos nulos.
        System.out.println("=== Livros encontrados ===");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitle());
            System.out.println("Autor(es):");
            if (livro.getAuthor_name() != null) {
                for (String autor : livro.getAuthor_name()) {
                    System.out.println("  - " + autor);
                }
            } else {
                System.out.println("  - Não disponível");
            }
            System.out.println("Idioma(s):");
            if (livro.getLanguage() != null) {
                for (String idioma : livro.getLanguage()) {
                    System.out.println("  - " + idioma);
                }
            } else {
                System.out.println("  - Não disponível");
            }if(livro.getPublisher() != null){
                for (String editora : livro.getPublisher()){
                    System.out.println("  - " +editora);
                }
            }else {
                System.out.println("  - Não disponível");
            }
            System.out.println("-----------------------------");
        }

        //converter lista de volta para Json para salvar no arq json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(livros);
        //cria arq json
        try (FileWriter writer = new FileWriter("livros.json")) {
            writer.write(json);
            System.out.println("Arquivo livros.json criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        leitor.close();
    }
}
