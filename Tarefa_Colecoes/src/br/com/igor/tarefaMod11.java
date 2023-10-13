package br.com.igor;
import java.util.*;

public class tarefaMod11 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite nomes separados por ,:");
        String nomes = s.nextLine();
        String[] vet = nomes.split(",");
        for (String i : vet){
            System.out.println(i);
        }
        System.out.println(" ");
        Arrays.sort(vet);
        for (String i : vet){
            System.out.println(i);
        }
    }
}
