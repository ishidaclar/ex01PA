package com.clara.exercicio01.services;

import com.clara.exercicio01.models.LivroModel;
import com.clara.exercicio01.repositories.LivroRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepositorie livroRepositorie;
    public List<LivroModel> findAll(){
        return livroRepositorie.findAll();
    }

    public LivroModel criarPessoa (LivroModel livroModel){
        return livroRepositorie.save(livroModel);
    }

    public Optional<LivroModel> findById(Long id){
        return livroRepositorie.findById(id);
    }

    public LivroModel atualizar (Long id, LivroModel livroModel){
        LivroModel model = livroRepositorie.findById(id).get();
        model.setTitulo(livroModel.getTitulo());
        return livroRepositorie.save(model);
    }

    public void remover(Long id){
        livroRepositorie.deleteById(id);
    }

}
