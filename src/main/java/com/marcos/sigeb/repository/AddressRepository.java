package com.marcos.sigeb.repository;

import com.marcos.sigeb.entity.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Modifying
    @Query("DELETE FROM Address a WHERE a.customer.id = :customerId")
    void deleteAddressByCustomerId(Long customerId);
}
