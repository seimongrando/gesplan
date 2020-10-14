package br.com.gesplan.domain.report;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TotalPorData {

	private LocalDate data;
	private Integer total;

}
