package com.banco.completo.finaly.service;

import com.banco.completo.finaly.entity.Client;
import com.banco.completo.finaly.entity.CurrentAccount;
import com.banco.completo.finaly.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<Client> searchClients() {
        return repository.findAll();
    }

    public void saveClient(Client client) {
        repository.save(client);

    }

    public Client searchClientById(Long id) {
        return repository.findById(id).get();
    }

    public void updateClient(Client client, Long id) {
        Client clientBank = repository.findById(id).orElseThrow(()->
               new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao pesquisar client"));

        BeanUtils.copyProperties(client, clientBank,"id"); //copia o upload de clientBanco para dentro de cliente
        this.saveClient(clientBank);
    }

    public void deleteCurrentAccount(CurrentAccount currentAccount, Long id) {
        Client clientBank = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao deletar cliente"));

        this.repository.delete(clientBank);
    }
}







