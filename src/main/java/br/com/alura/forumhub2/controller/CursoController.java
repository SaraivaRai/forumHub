package br.com.alura.forumhub2.controller;

import br.com.alura.forumhub2.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarCurso dados) {
        repository.save(new Curso(dados));
    }
    @GetMapping
    public ResponseEntity listarCurso(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        var page = repository.findAll();
        return ResponseEntity.ok(page);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Curso> exclui = repository.findById(id);
        if(exclui.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCurso dados) {
        var atualiza = repository.getReferenceById(dados.id());
        atualiza.atualizarCurso(dados);
        return ResponseEntity.ok(new DadosDetalharCurso(atualiza));
    }

}
