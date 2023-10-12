package br.com.igor;

import java.util.Scanner;

public class TarefaMod9 {

    public static void main(String args[]){
        Scanner idade = new Scanner(System.in);
        int i ;
        System.out.println("Insira Sua Idade: ");
        i = idade.nextInt();
        System.out.println("Sua idade: " + i);
        int id = new Integer(i);
        System.out.println("Sua idade na variavel Wrapper: " + id);
    }
}
