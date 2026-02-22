package enquetes.web.controller;

import enquetes.web.models.Opcao;
import enquetes.web.repository.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired // criando uma instancia diretamente de OpcaoRepository
    private OpcaoRepository opcaoRepository;

    // votos/{idDaOpcao}
    @PostMapping("/{opcaoId}")
    public ResponseEntity<Opcao> votar(@PathVariable Long opcaoId){
        return opcaoRepository.findById(opcaoId).map(opcao -> {
            // se encontrou o id, incrementa o contador
            opcao.setTotalVotos(opcao.getTotalVotos() + 1);
            // salva a opção de volta no banco com o voto já computado
            Opcao opcaoSalva = opcaoRepository.save(opcao);
            // vai retornar a opção atualizada e computada
            return ResponseEntity.ok(opcaoSalva);
        }).orElse(ResponseEntity.notFound().build()); // se não achar, vai retornar erro 404
    }
}