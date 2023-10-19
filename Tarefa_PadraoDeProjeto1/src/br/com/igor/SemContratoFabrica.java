package br.com.igor;

public class SemContratoFabrica extends Fabrica{
    @Override
    Carro retriveCarro(String requestedGrade) {
        if ("A".equals(requestedGrade)){
          return new Monza(89,"Alcool","Azul");
        } else if ("B".equals(requestedGrade)) {
            return new Monza(100,"Gasolina","Amarelo");
        } else {
            return null;
        }
    }
}
