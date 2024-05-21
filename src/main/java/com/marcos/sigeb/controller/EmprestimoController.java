package com.marcos.sigeb.controller;

import com.marcos.sigeb.entity.dto.EmprestimoDTO;
import com.marcos.sigeb.entity.model.Emprestimo;
import com.marcos.sigeb.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/create-emprestimo")
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = emprestimoService.createEmprestimo(emprestimoDTO);
        return ResponseEntity.ok().body(emprestimo);
    }

    @DeleteMapping("/delete-emprestimo/{id}")
    public ResponseEntity<Emprestimo> deleteEmprestimo(@PathVariable Long id){
        emprestimoService.deleteEmprestimo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-emprestimos")
    public Page<Emprestimo> getAllEmprestimos(Pageable pageable){
        return emprestimoService.getAllEmprestimos(pageable);
    }
}
