package br.com.ebac.animal_service.dto;

public class ResgatePorFuncionario {

    private String nomeRecebedor;
    private Long quantidade;

    public ResgatePorFuncionario(String nomeRecebedor, Long quantidade) {
        this.nomeRecebedor = nomeRecebedor;
        this.quantidade = quantidade;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
