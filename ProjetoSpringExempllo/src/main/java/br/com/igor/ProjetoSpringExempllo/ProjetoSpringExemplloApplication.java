package br.com.igor.ProjetoSpringExempllo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import br.com.igor.domain.Cliente;
import br.com.igor.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.igor.repository")
@EntityScan("br.com.igor.*")  
@ComponentScan(basePackages = "br.com.igor")
public class ProjetoSpringExemplloApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(ProjetoSpringExemplloApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringExemplloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("Parai")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.end("End")
				.estado("RS")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}
	

}
