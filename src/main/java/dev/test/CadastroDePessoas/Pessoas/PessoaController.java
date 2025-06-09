package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.ok("Pessoa cadastrada com sucesso!");
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
    @PutMapping("/alterar/{id}")
    public PessoaModel alterarPessoaPorId(@PathVariable Long id, @RequestBody PessoaModel pessoaAtualizada){
        return pessoaService.atualizarPessoa(id, pessoaAtualizada);
    }
    //Deletar Pessoa (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.ok("Pessoa deletada com sucesso!");
    }

}
