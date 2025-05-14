package dev.test.CadastroDePessoas.Carros;

import dev.test.CadastroDePessoas.Pessoas.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_carros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int ano;
    //Varios carros para 1 pessoa
    @ManyToOne
    @JoinColumn(name = "pessoas_id")
    private PessoaModel pessoa;
}

