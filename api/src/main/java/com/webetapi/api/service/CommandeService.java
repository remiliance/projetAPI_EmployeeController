package com.webetapi.api.service;

import com.webetapi.api.model.Commande;
import com.webetapi.api.model.Employee;
import com.webetapi.api.repository.CommandeRepository;
import com.webetapi.api.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;


    public Iterable<Commande> getCommandes() {
        return commandeRepository.findAll();
    }
}
