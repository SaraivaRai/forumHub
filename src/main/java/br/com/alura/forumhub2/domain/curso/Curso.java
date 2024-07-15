package br.com.alura.forumhub2.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String categoria;

    public Curso(DadosCadastrarCurso dados){
        this.id = dados.id();
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarCurso(DadosAtualizarCurso dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}


