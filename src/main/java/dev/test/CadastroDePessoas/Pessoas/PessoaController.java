package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.http.HttpStatus;
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
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Cadastrar pessoa (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa criada com sucesso");
    }

    //Procurar pessoa (READ)
    @GetMapping("/todos")
    public List<PessoaDTO> mostrarPessoa() {
        return pessoaService.listarPessoas();
    }

    //Mostrar pessoa por id(READ)
    //pathvbariable fala que a variavel vai aparecer no link para pesquisar quem quiser
    @GetMapping("/todos/{id}")
    public PessoaDTO mostrarPessoaID(@PathVariable Long id) {
        return pessoaService.listarPessoaId(id);
    }

    //Alterar dados das pessoas (UPDATE)
    @PutMapping("/alterar/{id}")
    public PessoaDTO alterarPessoaPorId(@PathVariable Long id, @RequestBody PessoaDTO pessoaAtualizada) {
        return pessoaService.atualizarPessoa(id, pessoaAtualizada);
    }

    //Deletar Pessoa (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        if (pessoaService.listarPessoaId(id) != null) {
            pessoaService.deletarPessoa(id);
            return ResponseEntity.ok("Pessoa deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body ("Pessoa nao encontrada");
        }
    }
}