package br.com.alura.forumhub2.domain.topico;

import br.com.alura.forumhub2.domain.curso.Curso;
import br.com.alura.forumhub2.domain.usuario.Usuario;

import java.time.LocalDate;

public record DadosCadastrarTopico(Long id, String titulo, String mensagem,
                                  LocalDate data, boolean status, Curso curso,
                                  Usuario usuario) {
}
