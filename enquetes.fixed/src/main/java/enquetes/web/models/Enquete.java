package enquetes.web.models;
// o modelo dos dados

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// getters e setters automáticos através da biblioteca lombok

import java.util.List;

// aqui se faz o modelo das nossas enquetes

@Entity //tabela no banco
@Getter
@Setter

public class Enquete {
    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pergunta;

    @OneToMany(mappedBy = "enquete", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Opcao> opcoes;
}