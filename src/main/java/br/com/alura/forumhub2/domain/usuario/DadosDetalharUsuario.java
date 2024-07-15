package br.com.alura.forumhub2.domain.usuario;

public record DadosDetalharUsuario(String nome, String email) {
    public DadosDetalharUsuario(Usuario atualizarUsuario) {
        this(atualizarUsuario.getNome(), atualizarUsuario.getEmail());
    }
}
