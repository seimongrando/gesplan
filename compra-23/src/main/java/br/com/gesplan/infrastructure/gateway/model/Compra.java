package br.com.gesplan.infrastructure.gateway.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Compra {

	private String cliente;
	
	private Double valor;
	
	private LocalDate data;
	
	private Integer quantidadeItens;

}
