package br.com.alura.forumhub2.controller;

import br.com.alura.forumhub2.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

   @Autowired
   private UsuarioRepository repository;

   @PostMapping
   @Transactional
   public Usuario cadastrar(@RequestBody @Valid DadosCadastrarUsuario dados){
       var encripta = new BCryptPasswordEncoder();
       var senhaCripto = encripta.encode(dados.senha());
       var usuario = new Usuario();
       usuario.setEmail(dados.email());
       usuario.setNome(dados.nome());
       usuario.setSenha(senhaCripto);

       repository.save(usuario);
       return usuario;
   }
   @GetMapping
   public ResponseEntity listarUsuarios(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
       var page = repository.findAll();
       return ResponseEntity.ok(page);
   }
   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity excluir(@PathVariable Long id) {
       Optional<Usuario> exclui = repository.findById(id);
       if(exclui.isPresent()) {
           repository.deleteById(id);
       }
       return ResponseEntity.noContent().build();
   }
   @PutMapping
   @Transactional
   public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarUsuario dados) {
       var atualiza = repository.getReferenceById(dados.id());
       atualiza.atualizarUsuario(dados);
       return ResponseEntity.ok(new DadosDetalharUsuario(atualiza));
   }
}
