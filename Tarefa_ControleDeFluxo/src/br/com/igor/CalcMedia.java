package br.com.igor;
import java.util.Scanner;
public class CalcMedia {
    public static void main(String args[]){
        Scanner nota = new Scanner(System.in);
        Integer nota1;
        Integer nota2;
        Integer nota3;
        Integer nota4;
        System.out.println("Insira a primeira nota:");
        nota1 = nota.nextInt();
        System.out.println("Insira a segunda nota:");
        nota2 = nota.nextInt();
        System.out.println("Insira a terceira nota:");
        nota3 = nota.nextInt();
        System.out.println("Insira a quarta nota:");
        nota4 = nota.nextInt();

        Integer soma = (nota1 + nota2 + nota3 + nota4);
        Integer media = (soma / 4);
        if (media >=7){
            System.out.println("Parabens voce foi aprovado");
        }
        else if (media >= 5 && media < 7){
            System.out.println("Voce esta de recuperação");
        }
        else{
            System.out.println("Voce foi reprovado");
        }
    }
}
