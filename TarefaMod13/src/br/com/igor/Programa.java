package br.com.igor;

public class Programa {
    public static void main(String[] args) {
        criandoPessoaFisica();
        criandoPessoaJuridica();
    }

    private static void criandoPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("TransportesLTDA");
        pj.setCnpj(32173l);
        System.out.println("Nome: "+ pj.getNome() + " CNPJ: "+ pj.getCnpj());
    }

    private static void criandoPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Igor");
        pf.setSobrenome("Minozzo");
        pf.setCpf(123l);
        System.out.println("Nome: " + pf.getNome() + " Sobrenome: "+ pf.getSobrenome() + " CPF: "+ pf.getCpf());
    }
}
