package br.com.gesplan.infrastructure.repository;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.gesplan.infrastructure.repository.document.CompraDocument;
import br.com.gesplan.infrastructure.repository.document.CompraPorClienteDocument;
import br.com.gesplan.infrastructure.repository.document.CompraPorDataDocument;

@Repository
public interface APIRepository extends MongoRepository<CompraDocument, String> {

	@Aggregation("{ $group : { _id : $cliente, total : { $sum : $valor } } }")
	AggregationResults<CompraPorClienteDocument> somaTotalPorCliente();
	
	@Aggregation("{ $group : { _id : $data, total : { $sum : $quantidadeItens } } }")
	AggregationResults<CompraPorDataDocument> somaTotalPorData();

}
