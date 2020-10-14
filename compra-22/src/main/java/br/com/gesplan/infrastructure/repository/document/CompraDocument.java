package br.com.gesplan.infrastructure.repository.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class CompraDocument {

	@Id
	private String id;
	private String cliente;
	private Double valor;
	private LocalDate data;
	private Integer quantidadeItens;

}
