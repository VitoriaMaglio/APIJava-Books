package br.fiap.api.com.tests;

import br.fiap.api.com.dao.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) {
        if (ConnectionFactory.obterConexao() == null) {
            System.out.printf("Conexão com erro!");
        }else{
            System.out.printf("Conexão estabelecida!");
        }
    }
}
