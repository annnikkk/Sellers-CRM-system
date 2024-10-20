package org.example.test_shift.services;

import org.example.test_shift.entities.Seller;
import org.example.test_shift.entities.Transaction;
import org.example.test_shift.exceptions.*;
import org.example.test_shift.repositories.SellerRepository;
import org.example.test_shift.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private SellerRepository sellerRepository;

    public TransactionService(TransactionRepository transactionRepository, SellerRepository sellerRepository) {
        this.transactionRepository = transactionRepository;
        this.sellerRepository = sellerRepository;
    }

    public List<Transaction> getAllTransactionList() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction with id: " + id + " not found"));
    }

    public Transaction createTransaction(int sellerId, Transaction transaction) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new SellerNotFoundException("Seller with id: " + sellerId + " not found"));

        transaction.setSeller(seller);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsBySellerId(int sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new SellerNotFoundException("Seller with id: " + sellerId + " not found"));

        return transactionRepository.findBySeller(seller);
    }

    public void deleteTransaction(int id) {
        Transaction transaction = getTransactionById(id);
        transactionRepository.delete(transaction);
    }
}
