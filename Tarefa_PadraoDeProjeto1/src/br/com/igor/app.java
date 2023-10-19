package br.com.igor;

public class app {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("A",true);
        Fabrica fabrica = getFabrica(cliente);
        Carro carro = fabrica.create(cliente.getGradeRequest());
        carro.ligando();
    }

    private static Fabrica getFabrica(Cliente cliente){
        if (cliente.getContrato()){
            return new ContratoFabrica();
        } else {
            return  new SemContratoFabrica();
        }
    }
}
