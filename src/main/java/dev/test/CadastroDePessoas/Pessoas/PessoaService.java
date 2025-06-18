package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static dev.test.CadastroDePessoas.Pessoas.PessoaMapper.*;

@Service
public final class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    //Listar todas as pessoas
    public List<PessoaDTO> listarPessoas() {
        List<PessoaModel> pessoa = pessoaRepository.findAll();
        return pessoa.stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar pessoas por ID
    public PessoaDTO listarPessoaId(Long id) {
        Optional<PessoaModel> pessoaPorId = pessoaRepository.findById(id);
        return pessoaPorId.map(pessoaMapper::map).orElse(null);

    }

    //Cadastrar pessoa
    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO) {
        PessoaModel pessoa = pessoaMapper.map(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.map(pessoa);
    }

    //Deletar pessoa por id, deletar precisa ser um metodo void
    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    //Atualizar dados
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO PessoaDTO) {
        Optional<PessoaModel> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isPresent()) {
            PessoaModel pessoaAtualizada = PessoaMapper.map(PessoaDTO);
            pessoaAtualizada.setId(id);
            PessoaModel pessoaSalva = pessoaRepository.save(pessoaAtualizada);
            return pessoaMapper.map(pessoaSalva);
        }
        return null;
    }
}

