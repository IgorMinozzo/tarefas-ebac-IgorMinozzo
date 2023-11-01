package br.com.igor.carros;

public class Honda extends Carros{
    @Override
    public String toString() {
        return "Carro Honda, modelo: " +getModelo() + " " + "placa: "+getPlaca();
    }
}
