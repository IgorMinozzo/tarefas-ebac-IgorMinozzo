package br.com.igor.testes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    static List<Pessoa> ListaGenero = new ArrayList<>();
    static List<Pessoa> listaFeminina = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o nome e gênero (separado por -), 'listar' para ver a lista feminina ou 'sair' para encerrar: ");
            String entrada = s.nextLine();
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            } else if (entrada.equalsIgnoreCase("listar")) {
                System.out.println(listaFeminina);
                System.out.println(ListaGenero);
            } else {
                String[] partes = entrada.split("-");
                if (partes.length == 2) {
                    Pessoa p = new Pessoa();
                    p.setNome(partes[0]);
                    p.setGenero(partes[1]);
                    if (p.getGenero().equals("F")){
                        listaFeminina.add(p);
                    }
                    else {
                        ListaGenero.add(p);
                    }
                }
            }
        }
    }
}
