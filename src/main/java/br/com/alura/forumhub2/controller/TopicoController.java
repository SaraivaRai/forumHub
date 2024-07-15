package br.com.alura.forumhub2.controller;

import br.com.alura.forumhub2.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    private Topico topico;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrarTopico dados) {
        repository.save(new Topico(dados));
    }
    @GetMapping
    public ResponseEntity listarTopicos(@PageableDefault(size = 10, 
            sort = {"data"})Pageable paginação) {
        var page = repository.findAll(Sort.by(Sort.Direction.DESC, "data"));
        return ResponseEntity.ok(page);
    }
    public ResponseEntity excluir (@PathVariable Long id) {
        Optional<Topico> exclui = repository.findById(id);
        if(exclui.isPresent()){
            repository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados) {
        var atualiza = repository.getReferenceById(dados.id());
        atualiza.atualizarTopico(dados);
        return ResponseEntity.ok(new DadosDetalharTopico(atualiza));        
    }

}
