package br.fiap.api.com.dao;

import br.fiap.api.com.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivroDao {
    //métodos crud
    public void cadastrarLivro(Livro livro) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        String sql = "INSERT INTO livro (title, author_name, publisher, language) VALUES(?,?,?,?)";

        try {
            comandoSQL = con.prepareStatement(sql);
            comandoSQL.setString(1, livro.getTitle());

            // Verificação se as listas não são nulas ou vazias
            if (livro.getAuthor_name() != null && !livro.getAuthor_name().isEmpty()) {
                comandoSQL.setString(2, livro.getAuthor_name().get(0));
            } else {
                comandoSQL.setString(2, "Desconhecido");
            }

            if (livro.getPublisher() != null && !livro.getPublisher().isEmpty()) {
                comandoSQL.setString(3, livro.getPublisher().get(0));
            } else {
                comandoSQL.setString(3, "Desconhecido");
            }

            if (livro.getLanguage() != null && !livro.getLanguage().isEmpty()) {
                comandoSQL.setString(4, livro.getLanguage().get(0));
            } else {
                comandoSQL.setString(4, "Desconhecido");
            }

            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir livro no banco.");
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) comandoSQL.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Livro buscarPorPk(String title) {
        Livro livro = null;
        String sql = "SELECT * FROM livro WHERE title = ?";

        try (Connection con = ConnectionFactory.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    livro = new Livro();
                    livro.setTitle(rs.getString("title"));
                    livro.setAuthor_name(Collections.singletonList(rs.getString("author_name")));
                    livro.setPublisher(Collections.singletonList(rs.getString("publisher")));
                    livro.setLanguage(Collections.singletonList(rs.getString("language")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }
    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection con = ConnectionFactory.obterConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setTitle(rs.getString("title"));
                livro.setAuthor_name(Collections.singletonList(rs.getString("author_name")));
                livro.setPublisher(Collections.singletonList(rs.getString("publisher")));
                livro.setLanguage(Collections.singletonList(rs.getString("language")));
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros.");
            e.printStackTrace();
        }
        return livros;
    }
}
