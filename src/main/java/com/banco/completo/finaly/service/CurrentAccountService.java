package com.banco.completo.finaly.service;

import com.banco.completo.finaly.entity.CurrentAccount;
import com.banco.completo.finaly.entity.Extract;
import com.banco.completo.finaly.entity.enums.OperationStatus;
import com.banco.completo.finaly.repository.CurrentAccountRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CurrentAccountService {

    @Autowired
    CurrentAccountRepository repository;

    public List<CurrentAccount> searchCurrentAccount() {
        return repository.findAll();
    }

    public CurrentAccount searchCurrentAccountById(Long id) {
        return repository.findById(id).get();
    }

    public void saveCurrentAccount(CurrentAccount currentAccount) {
        repository.save(currentAccount);
    }

    public void updateCurrentAccount(CurrentAccount currentAccount, Long id) {
        CurrentAccount currentAccountBank = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar current account"));

        BeanUtils.copyProperties(currentAccount, currentAccountBank, "id");
        this.saveCurrentAccount(currentAccountBank);
    }

    public void deleteCurrentAccount(CurrentAccount currentAccount, Long id) {
        CurrentAccount currentAccountBank = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao deletar cliente"));

        this.repository.delete(currentAccountBank);
    }
}


