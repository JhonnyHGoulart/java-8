package br.com.senai.lambdas;

import java.util.ArrayList;
import java.util.List;

public class OrdenaString {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("Editora casa do código");
        palavras.add("Caelum");

//        palavras.sort(( s1, s2) -> {
//                if (s1.length() < s2.length()) {
//                    return -1;
//                }
//                if (s1.length() > s2.length()) {
//                    return 1;
//                }
//                return 0;
//        });
// O código comentado a cima é equivalente ao código a baixo!

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(palavras);

//        Consumer<String> impressor = s -> System.out.println(s);
//        System.out.println(impressor);
// O código comentado a cima é equivalente ao código a baixo!

        palavras.forEach(s -> System.out.println(s)); //Lambda, implementando a interface Consumer por baixo dos panos
    }
}
