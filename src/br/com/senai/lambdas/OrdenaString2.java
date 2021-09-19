package br.com.senai.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString2 {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("Editora casa do código");
        palavras.add("Caelum");

        Comparator<String> comparador = new ComparePorTamanho();
        Collections.sort(palavras, comparador);
        palavras.sort(new ComparePorTamanho());
        System.out.println(palavras);

        palavras.sort(new ComparePorTamanho());
        System.out.println(palavras);

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(palavras);

        palavras.sort(Comparator.comparing(s -> s.length()));
        System.out.println(palavras);

        palavras.sort(Comparator.comparing(String::length));
        System.out.println(palavras);

        System.out.println("\n######InterfaceConsumer#######\n");

        Consumer<String> consumidor = new ImprimeNaLinha() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        System.out.println(palavras);

        Consumer<String> impressor = s -> System.out.println(s);

        Consumer<String> impressor2 = (s -> s.length());
        palavras.forEach(impressor2);
        System.out.println(palavras);

        Consumer<String> impressor3 = (String::length);
        palavras.forEach(impressor3);
        System.out.println(palavras);

    }
}


class ImprimeNaLinha implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparePorTamanho implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}