package br.com.gesplan.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.domain.report.TotalPorCliente;
import br.com.gesplan.domain.report.TotalPorData;
import br.com.gesplan.infrastructure.APIInfrastructure;

@RestController
public class APIController {
	
	private APIInfrastructure infrastructure;
	
	public APIController(
			final APIInfrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}

	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<Void> criarCompra(
			@Valid
			@RequestBody
    		final List<Compra> compras) {
		infrastructure.criarCompras(compras);
        return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(path = "/relatorios/clientes/total", produces = { "application/json" })
	public ResponseEntity<List<TotalPorCliente>> relatorioPorCliente() {
		return ResponseEntity.ok(infrastructure.somaTotalPorCliente());
	}

	@GetMapping(path = "/relatorios/clientes/data", produces = { "application/json" })
	public ResponseEntity<List<TotalPorData>> relatorioPorData() {
		return ResponseEntity.ok(infrastructure.somaTotalPorData());
	}

}
