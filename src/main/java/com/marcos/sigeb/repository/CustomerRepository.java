package com.marcos.sigeb.repository;

import com.marcos.sigeb.entity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
