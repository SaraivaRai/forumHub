package br.com.alura.forumhub2.domain.usuario;

public record DadosCadastrarUsuario(Long id, String nome,String email, String senha,
                                    boolean status){
}