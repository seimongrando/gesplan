package br.com.gesplan.infrastructure.repository.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class CompraPorDataDocument {

	@Id
	private LocalDate data;
	private Integer total;
	
}
