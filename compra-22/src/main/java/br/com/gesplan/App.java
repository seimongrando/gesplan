package br.com.gesplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.gesplan.*"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
