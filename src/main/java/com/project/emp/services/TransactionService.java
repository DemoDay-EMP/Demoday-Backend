package com.project.emp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emp.modelo.Transaction;
import com.project.emp.repository.TransactionRepository;



@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction updateTransaction(Integer id_lancamento, Transaction transaction) {
        Transaction existingTransaction = repository.findById(id_lancamento)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        existingTransaction.setValor(transaction.getValor());
        existingTransaction.setTipo_conta(transaction.getTipo_conta());
        existingTransaction.setData_lancamento(transaction.getData_lancamento());
        existingTransaction.setTipo_lancamento(transaction.getTipo_lancamento());
        existingTransaction.setCpf(transaction.getCpf());
        existingTransaction.setForma_pagamento(transaction.getForma_pagamento());
        existingTransaction.setObservacao(transaction.getObservacao());
        existingTransaction.setStatus_lancamento(transaction.getStatus_lancamento());

        return repository.save(existingTransaction);
    }

    public String deleteTransaction(Integer id_lancamento) {
        repository.deleteById(id_lancamento);
        return "Transação " + id_lancamento + " removida";
    }

    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction getTransactionById(Integer id_lancamento) {
        return repository.findById(id_lancamento)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public List<Transaction> getTransactionsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

}
