package com.webetapi.api.repository;

import com.webetapi.api.model.Commande;
import com.webetapi.api.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {
}
