package com.webetapi.api.controller;

import com.webetapi.api.model.Commande;
import com.webetapi.api.model.Employee;
import com.webetapi.api.service.CommandeService;
import com.webetapi.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    /**
     * Read - Get all commandes
     * @return - An Iterable object of commandes
     */
    @GetMapping("/commandes")
    public Iterable<Commande> getCommandess() {
        return commandeService.getCommandes();
    }


}
