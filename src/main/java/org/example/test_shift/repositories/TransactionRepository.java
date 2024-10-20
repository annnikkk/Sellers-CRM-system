package org.example.test_shift.repositories;

import org.example.test_shift.entities.Seller;
import org.example.test_shift.entities.Transaction;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySeller(Seller seller);
}
