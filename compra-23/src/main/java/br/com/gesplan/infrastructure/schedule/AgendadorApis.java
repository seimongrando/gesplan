package br.com.gesplan.infrastructure.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.gesplan.infrastructure.service.AgregadorService;

@Component
public class AgendadorApis {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private Integer quantidadeRegistros;
	private AgregadorService agregador;
	
	public AgendadorApis(
			@Value("${quantidadeRegistros:1}")
			final Integer quantidadeRegistros,
			final AgregadorService agregador) {
		this.quantidadeRegistros = quantidadeRegistros;
		this.agregador = agregador;
	}

	@Scheduled(cron = "${agendador.cron}")
    public void scheduleFixedRateTaskAsync() {
		log.info("--> iniciando agregador...");
        agregador.agregar(quantidadeRegistros);
    }

}
