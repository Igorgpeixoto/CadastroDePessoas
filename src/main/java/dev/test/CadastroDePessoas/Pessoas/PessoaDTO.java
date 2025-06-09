package dev.test.CadastroDePessoas.Pessoas;

import dev.test.CadastroDePessoas.Carros.CarrosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaDTO {


        private Long id;
        private String nome;
        private String email;
        private int idade;
        private List<CarrosModel> carros;

    }
