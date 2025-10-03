package br.fiap.api.com.tests;

import br.fiap.api.com.dao.LivroDao;
import br.fiap.api.com.model.Livro;
import br.fiap.api.com.service.LivroServico;

import java.util.List;
import java.util.Scanner;

public class TesteInserirLivro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        LivroDao livroDao = new LivroDao();
        LivroServico livroServico = new LivroServico();

        System.out.println("Digite o nome do livro que você deseja buscar na API Pública Open Library: ");
        String livroTitulo = leitor.nextLine();

        List<Livro> livros = livroServico.buscarLivro(livroTitulo);

        if (!livros.isEmpty()) {
            Livro livroEncontrado = livros.get(0);
            System.out.println("Livro encontrado: " + livroEncontrado.getTitle());

            livroDao.cadastrarLivro(livroEncontrado);
            System.out.println("Livro cadastrado no banco de dados.");

            Livro livroDoBanco = livroDao.buscarPorPk(livroEncontrado.getTitle());
            if (livroDoBanco != null) {
                System.out.println("Livro encontrado no banco: " + livroDoBanco.getTitle());
            } else {
                System.out.println("Livro não encontrado no banco de dados.");
            }
        } else {
            System.out.println("Nenhum livro encontrado na API.");
        }

        leitor.close();
    }
    }



