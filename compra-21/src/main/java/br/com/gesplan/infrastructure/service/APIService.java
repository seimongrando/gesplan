package br.com.gesplan.infrastructure.service;

import static org.springframework.util.Assert.notNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gesplan.domain.Compra;
import br.com.gesplan.infrastructure.APIInfrastructure;

@Service
public class APIService implements APIInfrastructure {
	
	@Override
	public List<Compra> compras(final Integer quantidade) {
		notNull(quantidade, "Parâmetro não deve ser nulo.");
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Parâmetro não deve ser zero ou negativo.");
		}
		List<Compra> compras = new ArrayList<>();
		for (int i = 0; i < quantidade; i++) {
			compras.add(Compra.builder().build());
		}
		return compras;
	}
	
}
