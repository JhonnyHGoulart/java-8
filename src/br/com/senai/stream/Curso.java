package br.com.senai.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }
}

class ExemploCurso {
    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Pyton", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

//        cursos.sort(Comparator.comparing(c -> c.getAlunos()));
        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.forEach(s -> System.out.println(s));

        System.out.println("#####################");
        cursos.forEach(System.out::println);

        System.out.println("#####################");
        cursos.forEach(c -> System.out.println(c.getNome()));

        System.out.println("######################");
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(c -> c.getAlunos())
                .forEach(total -> System.out.println(total));

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
        System.out.println(sum);

        System.out.println("########################");
        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .forEach(c -> System.out.println(c.getNome()));

        System.out.println("##########################");
        Stream<String> nomes = cursos.stream()
                .map(Curso::getNome);

        cursos.stream()
                .filter(c -> c.getAlunos() >= 50)
                .map(Curso::getNome)
                .forEach(System.out::println);


    }
}
