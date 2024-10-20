package org.example.test_shift.repositories;

import org.example.test_shift.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    boolean existsByContactInfo(String contactInfo);
}
