package br.com.opah.treinamento;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TreinamentoExemploApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TreinamentoExemploApplication.class, args);
	}
	
	
	@Autowired
	@Bean
	InitializingBean loadDatabase() {
				
		return () -> {
			System.out.println("Aqui serão executadas itens antes do carregamento do serviço");
		};
	}
}
