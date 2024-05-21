package com.marcos.sigeb.service;

import com.marcos.sigeb.entity.dto.EmprestimoDTO;
import com.marcos.sigeb.entity.model.Book;
import com.marcos.sigeb.entity.model.Customer;
import com.marcos.sigeb.entity.model.Emprestimo;
import com.marcos.sigeb.handlers.ResourceNotFoundException;
import com.marcos.sigeb.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    private final Integer DEFAULT_RETURN_DATE = 14;

    public Emprestimo createEmprestimo(EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = new Emprestimo();

        Customer customer = customerService.getCustomer(emprestimoDTO.getCustomerId());

        Book book = bookService.findBookById(emprestimoDTO.getBookId());

        if (customer == null) {
            throw new ResourceNotFoundException("Cliente com não encontrado com o Id: " + emprestimoDTO.getCustomerId());
        }

        if (book == null) {
            throw new ResourceNotFoundException("Livro não encontrado com o Id: " + emprestimoDTO.getBookId());
        }

        emprestimo.setId(null);
        emprestimo.setBook(book);
        emprestimo.setCustomer(customer);
        emprestimo.setCustomerName(customer.getNome());
        emprestimo.setTitulo(book.getTitulo());
        emprestimo.setDataEmprestimo(emprestimoDTO.getDataEmprestimo());
        emprestimo.setDataDevolucao(emprestimoDTO.getDataEmprestimo().plusDays(DEFAULT_RETURN_DATE));

        bookService.diminuirNumeroExemplaresDisponiveis(emprestimoDTO.getBookId());

        return emprestimoRepository.save(emprestimo);

    }

    public Page<Emprestimo> getAllEmprestimos(Pageable pageable){
        return emprestimoRepository.findAll(pageable);
    }

    public void deleteEmprestimo(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado com o Id: " + id));

        bookService.aumentarNumeroExemplaresDisponiveis(emprestimo.getBook().getId());

        emprestimoRepository.delete(emprestimo);
    }



}
