package br.com.igor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<Pessoa> ListaGenero = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (true){
            System.out.println("Digite o nome e gênero (separado por -), 'listar' para ver a lista feminina ou 'sair' para encerrar: ");
            String entrada = s.nextLine();
            if (entrada.equalsIgnoreCase("sair")){
                break;
            }
            else if (entrada.equalsIgnoreCase("listar")){
                List<Pessoa> listaFeminina = ListaGenero.stream()
                        .filter(pessoa -> pessoa.getGenero().equals("F")).collect(Collectors.toList());
                listaFeminina.forEach(p -> System.out.println(p.getNome()));
            }
            else {
                String[] partes = entrada.split("-");
                if (partes.length == 2){
                    Pessoa p = new Pessoa();
                    p.setNome(partes[0]);
                    p.setGenero(partes[1]);
                    ListaGenero.add(p);
                }
            }
        }

    }

}
