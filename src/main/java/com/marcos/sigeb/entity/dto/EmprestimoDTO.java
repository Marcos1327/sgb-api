package com.marcos.sigeb.entity.dto;

import java.time.LocalDate;

public class EmprestimoDTO {

    private Long customerId;

    private Long bookId;

    private LocalDate dataEmprestimo;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(Long customerId, Long bookId, LocalDate dataEmprestimo) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

}
