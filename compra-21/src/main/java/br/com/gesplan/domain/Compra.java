package br.com.gesplan.domain;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class Compra {

	@Default
	private String cliente 	= Faker.instance().funnyName().name();
	
	@Default
	private Double valor 	= Faker.instance().number().randomDouble(2, 1, 1000);
	
	@Default
	private LocalDate data = random();
	
	@Default
	private Integer quantidadeItens = Faker.instance().number().numberBetween(1, 100);

	private static LocalDate random() {
		LocalDate start = LocalDate.of(2020, Month.OCTOBER, 1);
	    long days = ChronoUnit.DAYS.between(start, LocalDate.now());
	    return start.plusDays(new Random().nextInt((int) days + 1));
	}

}
