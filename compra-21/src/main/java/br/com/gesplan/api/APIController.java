package br.com.gesplan.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.infrastructure.APIInfrastructure;

@RestController
public class APIController {

	private APIInfrastructure infrastructure;
	
	public APIController(final APIInfrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	@GetMapping(
			path = "{linhas}",
			produces = { "application/json" })
	public ResponseEntity<List<Compra>> listaCompras(
			@PathVariable("linhas") 
			final Integer linhas) {
		return ResponseEntity.ok(infrastructure.compras(linhas));
	}

}
