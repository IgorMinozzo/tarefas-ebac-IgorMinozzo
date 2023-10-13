package br.com.igor;
import java.util.*;
public class TarefaMod11Pt2 {
    public static void main(String[] args){
        List<String> ListaMasculino = new ArrayList<>();
        List<String> ListaFeminino = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Digite um nome e gênero (Exemplo: Gustavo-M) ou 'sair' para encerrar: ");
            String entrada = s.nextLine();
            if (entrada.equalsIgnoreCase("sair")){
                break;
            }
            else {
                String[] partes = entrada.split("-");
                if (partes.length == 2){
                    String nome = partes[0];
                    String genero = partes[1];
                    if (genero.equalsIgnoreCase("M")){
                        ListaMasculino.add(nome);
                    }
                    else if (genero.equalsIgnoreCase("F")){
                        ListaFeminino.add(nome);
                    }
                }
            }
        }
        System.out.println("**** Lista Homens ****");
        System.out.println(ListaMasculino);
        System.out.println("");
        System.out.println("**** Lista Mulheres ****");
        System.out.println(ListaFeminino);
    }
}

