package br.com.gesplan.infrastructure.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gesplan.infrastructure.gateway.Compra21Gateway;
import br.com.gesplan.infrastructure.gateway.Compra22Gateway;
import br.com.gesplan.infrastructure.gateway.model.Compra;

@Service
public class AgregadorService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private Compra21Gateway gateway21;
	private Compra22Gateway gateway22;
	
	public AgregadorService(
			final Compra21Gateway gateway21,
			final Compra22Gateway gateway22) {
		this.gateway21 = gateway21;
		this.gateway22 = gateway22;
	}
	
	public void agregar(final Integer registros) {
		
		ResponseEntity<List<Compra>> respostaGateway21 = gateway21.listaCompras(registros);
		
		if (respostaGateway21.getStatusCode().isError()) {
			log.error("--> falha ao recuperar lista de compras..processamento encerrado...");
			return;
		}
		
		ResponseEntity<Void> respostaGateway22 = gateway22.criarCompra(respostaGateway21.getBody());
		
		if (respostaGateway22.getStatusCode().isError()) {
			log.error("--> falha ao gravar lista de compras..processamento encerrado...");
			return;
		}
		
		log.info("--> processamento realizado com sucesso...");
		
	}
	
}
