package br.com.gesplan.infrastructure.repository.document;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class CompraPorClienteDocument {

	@Id
	private String cliente;
	private Double total;
	
}
