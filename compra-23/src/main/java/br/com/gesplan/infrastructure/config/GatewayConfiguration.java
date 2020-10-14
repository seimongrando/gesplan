package br.com.gesplan.infrastructure.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"br.com.gesplan.infrastructure.gateway"})
public class GatewayConfiguration {

}
