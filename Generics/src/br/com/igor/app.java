package br.com.igor;

import br.com.igor.carros.Carros;
import br.com.igor.carros.Honda;
import br.com.igor.carros.Volkswagen;

import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args) {
        List<Carros> carros = new ArrayList();

        Honda carroHonda = new Honda();
        carroHonda.setModelo("Civic");
        carroHonda.setPlaca("IKJ-4531");
        carros.add(carroHonda);

        Volkswagen carroVolks = new Volkswagen();
        carroVolks.setModelo("Golf");
        carroVolks.setPlaca("IED-3125");
        carros.add(carroVolks);
        System.out.println(carros);
    }
}
