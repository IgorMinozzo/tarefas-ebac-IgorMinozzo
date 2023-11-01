package br.com.igor.carros;

public abstract class Carros {

    private String modelo;
    private String placa;

    public void motorFuncionando() {
        System.out.println("Seu motor está ligado");
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
