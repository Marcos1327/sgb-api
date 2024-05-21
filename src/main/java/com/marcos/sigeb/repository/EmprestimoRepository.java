package com.marcos.sigeb.repository;

import com.marcos.sigeb.entity.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
}
