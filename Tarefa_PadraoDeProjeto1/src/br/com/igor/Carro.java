package br.com.igor;

public abstract class Carro {
    private Integer cavalos;
    private String combustivel;
    private String cor;

    public Carro(Integer cavalos, String combustivel, String cor) {
        this.cavalos = cavalos;
        this.combustivel = combustivel;
        this.cor = cor;
    }

    public void ligando(){
        System.out.println("Ligando seu carro, com o combustivel:" +combustivel + " e com " + cavalos + " cavalos");
    }
     public void limpo(){
        System.out.println("Seu carro está limpo e com a cor "+ cor +" brilhando");
     }

     public void mecanico(){
        System.out.println("Seu carro está todo revisado");
     }


    public Integer getCavalos() {
        return cavalos;
    }

    public void setCavalos(Integer cavalos) {
        this.cavalos = cavalos;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
