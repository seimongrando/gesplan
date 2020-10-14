package br.com.gesplan.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.domain.report.TotalPorCliente;
import br.com.gesplan.domain.report.TotalPorData;
import br.com.gesplan.infrastructure.repository.document.CompraDocument;
import br.com.gesplan.infrastructure.repository.document.CompraPorClienteDocument;
import br.com.gesplan.infrastructure.repository.document.CompraPorDataDocument;

@Mapper(componentModel = "spring")
public interface APIMapper {

	List<CompraDocument> mapCompraDocument(final List<Compra> source);

	List<TotalPorCliente> mapTotalPorCliente(final List<CompraPorClienteDocument> source);
	
	List<TotalPorData> mapTotalPorData(final List<CompraPorDataDocument> source);
	
}
