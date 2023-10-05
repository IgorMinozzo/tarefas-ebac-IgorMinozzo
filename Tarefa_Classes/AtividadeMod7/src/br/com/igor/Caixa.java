package br.com.igor;

public class Caixa {

    public static void main(String[] args) {

        /**
         * Cadastrando produtos e ulitizando os métodos criados.
         */

        Produtos p1 = new Produtos();
        p1.setCodigo(1);
        p1.setNome("Leite");
        p1.setValor(5.85f);
        p1.imprimirProduto();

        Produtos p2 = new Produtos();
        p2.setCodigo(2);
        p2.setNome("Arroz");
        p2.setValor(28.67f);
        p2.descontoProduto();
        p2.imprimirProduto();
    }
}
