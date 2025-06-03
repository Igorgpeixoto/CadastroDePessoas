package dev.test.CadastroDePessoas.Carros;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carros") //requestmapping serve para falar que tudo sera mapeado

public class CarrosController {

    //Cadastrar carro (CREATE)
    @PostMapping("/criar")
    public String criarCarro() { return "Carro criado"; }

    //Procurar carro (READ)
    @GetMapping("/listar")
    public String mostrarCarro() { return "Carros Listados com sucesso"; }

    //Alterar dados dos carros (UPDATE)
    @PutMapping("/alterar")
    public String alterarCarro() { return "Carro alterado"; }

    //Deletar Pessoa (DELETE)
    @DeleteMapping("/deletar")
    public String deletarCarro() { return "Carro deletado com sucesso"; }

}
