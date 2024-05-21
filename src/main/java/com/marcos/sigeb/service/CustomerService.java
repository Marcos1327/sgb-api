package com.marcos.sigeb.service;

import com.marcos.sigeb.entity.dto.AddressDTO;
import com.marcos.sigeb.entity.dto.CustomerDTO;
import com.marcos.sigeb.entity.model.Address;
import com.marcos.sigeb.entity.model.Customer;
import com.marcos.sigeb.handlers.ResourceNotFoundException;
import com.marcos.sigeb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;


    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCustomerId(null);
        customer.setNome(customerDTO.getNome());
        customer.setSobrenome(customerDTO.getSobrenome());
        customer.setIdade(customerDTO.getIdade());
        customer.setNumeroContato(customerDTO.getNumeroContato());
        customer.setDataCadastro(LocalDate.now());

        List<Address> endereços = new ArrayList<>();

        for (AddressDTO addressDTO : customerDTO.getEndereço()) {
            Address address = addressService.createAddress(addressDTO);
            address.setCustomer(customer);
            endereços.add(address);
        }

        customer.setEndereços(endereços);

        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id: " + id));
    }

    public void deleteCustomer(Long id) {

        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found for id: " + id);
        }

        customerRepository.deleteById(id);
    }
}
