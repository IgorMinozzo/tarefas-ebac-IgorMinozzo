package br.com.igor.reflections;

import java.lang.annotation.Annotation;

public class App {
    public static void main(String[] args) {
        leituraAnotacao();
    }

    private static void leituraAnotacao() {
        System.out.println("---------Annotations---------");
        TabelaAnotação tab = new TabelaAnotação();
        Annotation[] annotations = tab.getClass().getAnnotations();
        for (Annotation an : annotations) {
            System.out.println("Annotation type: " + an.annotationType());
        }
    }
}
