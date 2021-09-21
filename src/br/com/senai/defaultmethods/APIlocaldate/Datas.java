package br.com.senai.defaultmethods.APIlocaldate;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        System.out.println("#############");

        LocalDate olimpiadasDoRio = LocalDate.of(2016, Month.JUNE, 5);
        int anos = olimpiadasDoRio.getYear() - hoje.getYear();
        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadasDoRio);
        System.out.println(periodo.getDays());
        System.out.println("################");

        LocalDate proximasOlimpiadas = olimpiadasDoRio.plusYears(4);
        System.out.println(proximasOlimpiadas);
        System.out.println("################");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);
        System.out.println("################");

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));
        System.out.println("###############");

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);
        System.out.println("#################");

        ZonedDateTime fusoHorario = ZonedDateTime.now();
        System.out.println(fusoHorario);

    }
}
