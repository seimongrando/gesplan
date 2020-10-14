package br.com.gesplan.infrastructure.gateway;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gesplan.infrastructure.gateway.model.Compra;

@FeignClient(name="${compra.22.name}", url="${compra.22.url}")
public interface Compra22Gateway {

	@PostMapping(path = "/", consumes = { "application/json" })
	ResponseEntity<Void> criarCompra(
			@RequestBody
    		final List<Compra> compras);
	
}
