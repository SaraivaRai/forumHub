package br.com.alura.forumhub2.domain.topico;

import br.com.alura.forumhub2.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosDetalharTopico(@NotNull Long id, String titulo, String mensagem,
                                  boolean Status, Curso curso) {
    public DadosDetalharTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensagem(),
                topico.isStatus(), topico.getCurso());
    }
}
