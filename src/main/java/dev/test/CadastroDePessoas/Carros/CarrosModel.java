package dev.test.CadastroDePessoas.Carros;

import dev.test.CadastroDePessoas.Pessoas.PessoaModel;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_carros")
public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int ano;
   //Varios carros para 1 pessoa
    @ManyToOne
    @JoinColumn(name = "pessoas_id")
    private PessoaModel pessoa;

    public CarrosModel() {
    }

    public CarrosModel(String nome, int ano) {

        this.nome = nome;
        this.ano = ano;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
