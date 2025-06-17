package dev.test.CadastroDePessoas.Pessoas;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public static PessoaModel map(PessoaDTO pessoaDTO) {

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setEmail(pessoaDTO.getEmail());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        pessoaModel.setCarros(pessoaDTO.getCarros());

        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel) {

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setEmail(pessoaModel.getEmail());
        pessoaDTO.setIdade(pessoaModel.getIdade());
        pessoaDTO.setCarros(pessoaModel.getCarros());

        return pessoaDTO;
    }

}
