package br.com.gesplan.infrastructure.gateway;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gesplan.infrastructure.gateway.model.Compra;

@FeignClient(name="${compra.21.name}", url="${compra.21.url}")
public interface Compra21Gateway {

	@GetMapping(
			path = "{linhas}",
			produces = { "application/json" })
	ResponseEntity<List<Compra>> listaCompras(
			@PathVariable("linhas") 
			final Integer linhas);
	
}
