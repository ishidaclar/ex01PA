package com.clara.exercicio01.controllers;


import com.clara.exercicio01.models.LivroModel;
import com.clara.exercicio01.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/livros")

public class LivroController {

@Autowired
private LivroService livroService;

@GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
    List<LivroModel> requeste = livroService.findAll();
    return ResponseEntity.ok().body(requeste);
}

@PostMapping ResponseEntity<LivroModel> criarPessoa(@RequestBody LivroModel livroModel) {
LivroModel requeste = livroService.criarLivro(livroModel);
URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri() //aqui ele ta pegando a URL atual
        .path("/{id}").buildAndExpand(livroModel.getId())//aqui ele ta adicionando o id na URL e está pegando tal id pelo GETID
        .toUri(); //aqui ele esta convertendo para objeto uri

return ResponseEntity.created(uri).body(requeste);
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
    livroService.remover(id);
    return ResponseEntity.noContent().build();
}

@GetMapping("/{id}")
public Optional<LivroModel> buscarId(@PathVariable Long id) {
    //esse optional ai quer dizer que pode acontecer ou nao
    return livroService.findById(id);
}

//a diferença desse get pro outro é que o outro retorna todos os objetos, enquanto esse retorna só o desejado






}