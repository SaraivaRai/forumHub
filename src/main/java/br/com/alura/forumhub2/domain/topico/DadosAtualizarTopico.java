package br.com.alura.forumhub2.domain.topico;

import br.com.alura.forumhub2.domain.curso.Curso;

public record DadosAtualizarTopico(Long id, String titulo, String mensagem,
                                   boolean status, Curso curso) {
}
