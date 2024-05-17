package com.marcos.sigeb.service;

import com.marcos.sigeb.entity.dto.AddressDTO;
import com.marcos.sigeb.entity.model.Address;
import com.marcos.sigeb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setAddressId(null);
        address.setCep(addressDTO.getCep());
        address.setLocalidade(addressDTO.getLocalidade());
        address.setLogradouro(addressDTO.getLogradouro());

        return addressRepository.save(address);
    }

    public void deleteAddressByCustomerId(Long id) {
//        addressRepository.deleteByCustomerId(id);
    }
}
