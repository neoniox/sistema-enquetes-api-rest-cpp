package enquetes.web.repository;

import enquetes.web.models.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;

// nos oferecerá os mesmos métodos ditos antes
public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
}