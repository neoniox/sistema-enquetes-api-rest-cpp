package enquetes.web.controller;
// a API, aqui serão definidos os endpoints (urls) para que o usuário possa interagir com o sistema

import enquetes.web.models.Enquete;
import enquetes.web.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import enquetes.web.models.Opcao; // para importar a opção das enquetes


import java.util.List;

@RestController
@RequestMapping("/enquetes") // todas as urls aqui começarão com /enquetes
public class EnqueteController {

    @Autowired // injetando uma instancia do repositorio aqui
    private EnqueteRepository enqueteRepository;

    @GetMapping // aqui leremos todas as enquetes disponíveis
    public List<Enquete> listarTodas(){
        return enqueteRepository.findAll(); //retornará todas as enquetes graças ao findAll()
    }

    @GetMapping("/{id}") // ler uma enquete diretamente pelo seu id
    public ResponseEntity<Enquete> buscarPorId(@PathVariable Long id){
        // findById retorna um "Optional"
        // .map() é uma forma de dizer "se encontrou, retorne OK(enquete)"
        // .orElse() diz "senão, retorne NotFound(404)"
        return enqueteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // post para fazer mais enquetes
    @PostMapping
    public Enquete criarEnquete(@RequestBody Enquete enquete){
        // quando o json chega, as opções não sabem a qual enquete pertencem
        // nós precisamos "amarrar" as pontas antes de salvar
        if(enquete.getOpcoes() != null){
            for(Opcao op : enquete.getOpcoes()){
                op.setEnquete(enquete); // diz à opção "eu sou seu pai" (ou seja, a qual enquete ela pertence)
            }
        }
        return enqueteRepository.save(enquete);
    }

    // put para atualizar o texto da pergunta
    @PutMapping("/{id}")
    public ResponseEntity<Enquete> atualizarEnquete(@PathVariable Long id, @RequestBody Enquete enqueteAtualizada) {
        return enqueteRepository.findById(id).map(enqueteExistente -> {
            // vamos atualizar apenas a pergunta (manter as opções iguais)
            enqueteExistente.setPergunta(enqueteAtualizada.getPergunta());

            Enquete salva = enqueteRepository.save(enqueteExistente);
            return ResponseEntity.ok(salva);
        }).orElse(ResponseEntity.notFound().build());
    }

    // delete para deletar a enquete que quiser
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnquete(@PathVariable Long id) {
        if (enqueteRepository.existsById(id)) {
            enqueteRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // vai retornar 204 se a enquete for deletada
        }
        return ResponseEntity.notFound().build();
    }
}

