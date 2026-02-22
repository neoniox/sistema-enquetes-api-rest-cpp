package enquetes.web.repository;
// acesso aos dados

import enquetes.web.models.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;

// esta interface nos dará métodos como save(), findAll(), etc

public interface EnqueteRepository extends JpaRepository<Enquete, Long> {
}