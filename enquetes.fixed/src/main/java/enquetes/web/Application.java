package enquetes.web;

// ALUNOS
// Emiliano de Andrade Landim Lucero
// João Paulo dos Santos Nascimento
// Karolyne Cunha Barbosa
// Lara Oliveira Machado Borges Ferreira
// Nicole Santana Araujo

import enquetes.web.repository.EnqueteRepository;
import enquetes.web.models.Enquete;
import enquetes.web.models.Opcao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // ESTATICO, não tem como retirar esta enquete padrão
	public CommandLineRunner initDatabase(EnqueteRepository enqueteRepository) {
		return args -> {
			Enquete enquete1 = new Enquete();
			enquete1.setPergunta("Qual sua linguagem de back-end favorita?");

			Opcao op1 = new Opcao();
			op1.setTexto("Java (Spring)");
			op1.setEnquete(enquete1); // associa à enquete

			Opcao op2 = new Opcao();
			op2.setTexto("Python (Django)");
			op2.setEnquete(enquete1);

			Opcao op3 = new Opcao();
			op3.setTexto("JavaScript (Node.js)");
			op3.setEnquete(enquete1);

			// vai adicionar as opções na lista da enquete
			enquete1.setOpcoes(List.of(op1, op2, op3));

			// vai salvar a enquete (e, graças ao CascadeType.ALL, as opções vão junto)
			enqueteRepository.save(enquete1);
		};
	}
}
