package enquetes.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto; //texto da opção
    private int totalVotos = 0; //contador de votos naquela enquete

    // muitas opções pertencem a uma enquete
    @ManyToOne
    @JoinColumn(name = "enquete_id") // a coluna do banco que nos liga à enquete
    @JsonIgnore // evita loops infinitos ao converter para json
    private Enquete enquete;
}