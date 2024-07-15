package br.com.alura.forumhub2.domain.topico;

import br.com.alura.forumhub2.domain.curso.Curso;
import br.com.alura.forumhub2.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "topico")
@Table(name = "topicos")
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDate data;
    private boolean status;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico(DadosCadastrarTopico dados) {
        this.id = dados.id();
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = dados.data();
        this.status = dados.status();
        this.curso = dados.curso();
        this.usuario = dados.usuario();
    }

    public void atualizarTopico(DadosAtualizarTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() !=null) {
            this.curso = dados.curso();
        }
    }

}
