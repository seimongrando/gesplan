package br.com.gesplan.infrastructure;

import java.util.List;

import br.com.gesplan.domain.Compra;

public interface APIInfrastructure {

	List<Compra> compras(final Integer quantidade);
	
}
