package br.com.igor;

public class Calculo {
    public static void main(String[] args) {
        calculoMedia();
    }

    private static void calculoMedia() {
        Float n1 = 10.0f;
        Float n2 = 7.0f;
        Float n3 = 4.6f;
        Float n4 = 4.8f;

        Float somaMedia = (n1 + n2 + n3 + n4);
        Float media = (somaMedia / 4);
        if (media >= 7){
            System.out.println("Parabéns! você foi aprovado!");
        }
        else if (media >=5){
            System.out.println("Você está de recuperação!");
        }
        else{
            System.out.println("Você foi reprovado!");
        }
    }
}
