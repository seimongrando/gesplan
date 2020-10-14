package br.com.gesplan.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class Compra {

	@NotNull
	private String cliente;
	
	@NotNull
	private Double valor;
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	private Integer quantidadeItens;

}
