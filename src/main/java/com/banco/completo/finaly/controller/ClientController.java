package com.banco.completo.finaly.controller;

import com.banco.completo.finaly.entity.Client;
import com.banco.completo.finaly.entity.CurrentAccount;
import com.banco.completo.finaly.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController //end point mapeamento
@RequestMapping("/system")

public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> searchClients() {
        return clientService.searchClients();
    }

    @GetMapping("/clients/{id}")
    private Client searchClient(@PathVariable("id") Long id) {
        return clientService.searchClientById(id);
    }
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }
    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateClient(@PathVariable("id")Long id, @RequestBody Client client) {
        clientService.updateClient(client, id);
    }
    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteCurrentAccount(@PathVariable("id") Long id, @RequestBody CurrentAccount currentAccount) {
        clientService.deleteCurrentAccount(currentAccount, id);
    }
}
