package br.com.igor;

public abstract class Fabrica {
    public Carro create(String requestdGrade){
        Carro carro = retriveCarro(requestdGrade);
        carro = prepareCarro(carro);
        return carro;
    }

    private Carro prepareCarro(Carro carro){
        carro.mecanico();
        carro.limpo();
        return carro;
    }
    abstract Carro retriveCarro(String requestedGrade);
}
