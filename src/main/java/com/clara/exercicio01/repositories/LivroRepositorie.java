package com.clara.exercicio01.repositories;

import com.clara.exercicio01.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorie extends JpaRepository<LivroModel, Long> {
}
}
