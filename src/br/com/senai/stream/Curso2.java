package br.com.senai.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Curso2 {
    private String nome;
    private int alunos;

    public Curso2(String nome, int alunos) {
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

class ExemploCurso2 {
    public static void main(String[] args) {

        List<Curso2> cursos = new ArrayList<Curso2>();
        cursos.add(new Curso2("Pyton", 45));
        cursos.add(new Curso2("JavaScript", 150));
        cursos.add(new Curso2("Java 8", 113));
        cursos.add(new Curso2("C", 55));

//        cursos.sort(Comparator.comparing(Curso2::getAlunos));
//
//        cursos.forEach(c -> System.out.println(c.getNome()));
//        System.out.println("####################");
//
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso2::getAlunos)
                .sum();
        System.out.println(sum);

        OptionalDouble optionalMedia = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso2::getAlunos)
                .average();
        System.out.println(optionalMedia);

        Optional<Curso2> optionalCurso = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();
        optionalCurso.get();
        Curso2 curso = optionalCurso.orElse(null);
        System.out.println(curso.getNome());
        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        cursos = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());
        cursos.stream()
                .forEach(c -> System.out.println(c.getNome()));

        System.out.println("####################");
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome,alunos) -> System.out.println(nome+" tem "+alunos+ " alunos "));

    }
}

