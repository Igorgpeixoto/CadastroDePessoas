package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas () {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Cadastrar pessoa (CREATE)
    @PostMapping("/criar")
    public String criarPessoa() {
        return "Pessoa cadastrada";
    }
    //Procurar pessoa (READ)
    @GetMapping("/todos")
    public List<PessoaModel> mostrarPessoa(){
        return pessoaService.listarPessoas();
    }
    //Mostrar pessoa (READ)
    @GetMapping("/todosID")
    public String mostrarPessoaID() {
        return "mostrar pessoa ID";
    }
    //Alterar dados das pessoas (UPDATE)
    @PutMapping("/alterar")
    public String alterarPessoaPorId(){
        return "Alterar por id";
    }
    //Deletar Pessoa (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPorId(){
        return "Deletar por id";
    }
}
