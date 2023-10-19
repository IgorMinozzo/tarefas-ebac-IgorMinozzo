package br.com.igor;

public class ContratoFabrica extends Fabrica{
    @Override
    Carro retriveCarro(String requestedGrade) {
        if ("A".equals(requestedGrade)){
            return new Porshe(560,"Gasolina","Branco");
        } else if ("B".equals(requestedGrade)){
               return new Porshe(700,"Gasolina","Preta");
        }else {
            return null;
        }
    }
}

