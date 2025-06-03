package dev.test.CadastroDePessoas.Pessoas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class PessoaController {
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
    public String mostrarPessoa(){
        return "mostrar pessoa";
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
