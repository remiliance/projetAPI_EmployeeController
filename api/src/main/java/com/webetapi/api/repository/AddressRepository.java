package com.webetapi.api.repository;

import com.webetapi.api.model.Address;
import com.webetapi.api.model.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
