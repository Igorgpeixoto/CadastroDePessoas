package dev.test.CadastroDePessoas.Pessoas;

import dev.test.CadastroDePessoas.Carros.CarrosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
//NOARGS E ALLARGS SUBSTITUEM OS CONTRUTORES E GETERS E SETTERS, É USADO ADICIONANDO A DEPENDENCIA DO LOMBOK
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
  //Uma pessoa pode alugar varios carros
   @OneToMany (mappedBy = "pessoa")
    private List<CarrosModel> carros;

    public PessoaModel() {
    }

}
