package com.project.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.emp.modelo.Transaction;
import com.project.emp.services.TransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping(value = "/create", produces = "application/json")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> findAllTransactions() {
        return service.getTransactions();
    }

    @GetMapping("/{id_lancamento}")
    public Transaction findTransactionById(@PathVariable Integer id_lancamento) {
        return service.getTransactionById(id_lancamento);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Transaction> findTransactionsByCpf(@PathVariable String cpf) {
        return service.getTransactionsByCpf(cpf);
    }

    @PutMapping("/{id_lancamento}")
    public Transaction updateTransaction(@PathVariable("id_lancamento") Integer id, @RequestBody Transaction transaction) {
        return service.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id_lancamento}")
    public String deleteTransaction(@PathVariable Integer id_lancamento) {
        return service.deleteTransaction(id_lancamento);
    }
}
