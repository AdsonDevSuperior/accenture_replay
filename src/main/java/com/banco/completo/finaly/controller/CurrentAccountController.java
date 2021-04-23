package com.banco.completo.finaly.controller;

import com.banco.completo.finaly.entity.CurrentAccount;
import com.banco.completo.finaly.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;;

@RestController
@RequestMapping("/system")
public class CurrentAccountController {

    @Autowired
    CurrentAccountService service;

    private static final String APPLICATION_JSON = "application/json";
    private Object getCurrentAccountService;

    @GetMapping("/current_account")
    public List<CurrentAccount> searchCurrentAccounts() {
        return service.searchCurrentAccount();
    }

    @GetMapping("/current_account/{id}")
    private CurrentAccount searchCurrentAccount(@PathVariable("id") Long id) {
        return service.searchCurrentAccountById(id);
    }

    @PostMapping("/current_account")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCurrentAccounts(@RequestBody CurrentAccount currentAccount) {
        service.saveCurrentAccount(currentAccount);
    }

    @PutMapping("/current_account/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCurrentAccount(@PathVariable("id") Long id, @RequestBody CurrentAccount currentAccount) {
        service.updateCurrentAccount(currentAccount, id);
    }

    @DeleteMapping("/current_account/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteCurrentAccount(@PathVariable("id") Long id, @RequestBody CurrentAccount currentAccount) {
        service.deleteCurrentAccount(currentAccount, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CurrentAccount> update(@PathVariable Long id, @RequestBody CurrentAccount obj) {
        return ResponseEntity.ok().body(obj);
    }
}