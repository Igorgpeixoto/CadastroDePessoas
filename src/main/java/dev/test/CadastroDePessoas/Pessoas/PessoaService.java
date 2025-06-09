package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    //Listar todas as pessoas
    public List<PessoaModel> listarPessoas(){
        return pessoaRepository.findAll();
    }
    //Listar pessoas por ID
    public PessoaModel listarPessoaId(Long id){
        Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
        return pessoaModel.orElse(null);
    }
    //Cadastrar pessoa
    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO){
        PessoaModel pessoa = pessoaMapper.map(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.map(pessoa);
    }
    //Deletar pessoa por id, deletar precisa ser um metodo void
    public void deletarPessoa (Long id){
        pessoaRepository.deleteById(id);
    }
    //Atualizar dados
    public PessoaModel atualizarPessoa (Long id, PessoaModel pessoaAtualizada) {
        if (pessoaRepository.existsById(id)) {
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        }
        return null;
    }

    }

