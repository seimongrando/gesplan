package br.com.gesplan.infrastructure;

import java.util.List;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.domain.report.TotalPorCliente;
import br.com.gesplan.domain.report.TotalPorData;

public interface APIInfrastructure {

	void criarCompras(final List<Compra> compras);
	
	List<TotalPorCliente> somaTotalPorCliente();
	
	List<TotalPorData> somaTotalPorData();

}
