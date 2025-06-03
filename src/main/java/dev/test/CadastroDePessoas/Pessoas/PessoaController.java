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
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    //Procurar pessoa (READ)
    @GetMapping("/todos")
    public List<PessoaModel> mostrarPessoa(){
        return pessoaService.listarPessoas();
    }

    //Mostrar pessoa por id(READ)
    //pathvbariable fala que a variavel vai aparecer no link para pesquisar quem quiser
    @GetMapping("/todos/{id}")
    public PessoaModel mostrarPessoaID(@PathVariable Long id) {
        return pessoaService.listarPessoaId(id);
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
