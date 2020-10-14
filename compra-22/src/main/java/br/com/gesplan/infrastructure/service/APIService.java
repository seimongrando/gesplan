package br.com.gesplan.infrastructure.service;

import static org.springframework.util.Assert.notNull;
import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.domain.report.TotalPorCliente;
import br.com.gesplan.domain.report.TotalPorData;
import br.com.gesplan.infrastructure.APIInfrastructure;
import br.com.gesplan.infrastructure.mapper.APIMapper;
import br.com.gesplan.infrastructure.repository.APIRepository;
import br.com.gesplan.infrastructure.repository.document.CompraPorClienteDocument;
import br.com.gesplan.infrastructure.repository.document.CompraPorDataDocument;

@Service
public class APIService implements APIInfrastructure {

	private APIRepository repository;
	private APIMapper mapper;
	
	public APIService(
			final APIRepository repository,
			final APIMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public void criarCompras(final List<Compra> compra) {
		notNull(compra, "Compras não deve ser nula.");
		notEmpty(compra, "Lista de compra não deve estar vazia.");
		repository.saveAll(mapper.mapCompraDocument(compra));
	}
	
	@Override
	public List<TotalPorCliente> somaTotalPorCliente() {
		AggregationResults<CompraPorClienteDocument> soma = repository.somaTotalPorCliente();
		return mapper.mapTotalPorCliente(soma.getMappedResults());
	}
	
	@Override
	public List<TotalPorData> somaTotalPorData() {
		AggregationResults<CompraPorDataDocument> soma = repository.somaTotalPorData();
		return mapper.mapTotalPorData(soma.getMappedResults());
	}

}
