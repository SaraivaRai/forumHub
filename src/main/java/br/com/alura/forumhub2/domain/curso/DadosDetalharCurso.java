package br.com.alura.forumhub2.domain.curso;

import br.com.alura.forumhub2.domain.usuario.DadosDetalharUsuario;

public record DadosDetalharCurso(Long id, String nome, String categoria) {
    public DadosDetalharCurso(Curso atualizarCurso) {
        this(atualizarCurso.getId(), atualizarCurso.getNome(), atualizarCurso.getCategoria());
    }
}
