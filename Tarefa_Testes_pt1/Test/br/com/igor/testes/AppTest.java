package br.com.igor.testes;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AppTest {

    @Test
    public void testGenero() {

        String entradaSimulada = "Maria-F\nJoao-M\nsair";
        InputStream inputStream = new ByteArrayInputStream(entradaSimulada.getBytes());
        System.setIn(inputStream);


        App.main(new String[]{});

        // Verificar se a listaFeminina contém apenas elementos do gênero "F"
        for (Pessoa pessoa : App.listaFeminina) {
            Assert.assertEquals("F", pessoa.getGenero());
        }

        // Restaurar a entrada padrão do System.in
        System.setIn(System.in);
    }
}
