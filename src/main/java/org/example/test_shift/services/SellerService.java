package org.example.test_shift.services;

import org.example.test_shift.entities.Seller;
import org.example.test_shift.exceptions.*;
import org.example.test_shift.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getAllSellerList(){
        return sellerRepository.findAll();
    }

    public Seller getSellerById(int id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new SellerNotFoundException("Seller with id: " + id + " not found"));
    }

    public Seller createSeller(Seller seller) {
        if (sellerRepository.existsByContactInfo(seller.getContactInfo())) {
            throw new DuplicateSellerException("Seller with email: " + seller.getContactInfo() + " already exists");
        }

        if (seller.getName() == null || seller.getContactInfo() == null) {
            throw new InvalidSellerInfoException("Seller name and email cannot be empty");
        }

        return sellerRepository.save(seller);
    }

    public Seller updateSeller(int id, Seller updatedSeller) {
        Seller existingSeller = getSellerById(id);
        if (sellerRepository.existsByContactInfo(updatedSeller.getContactInfo())) {
            throw new DuplicateSellerException("Seller with email: " + updatedSeller.getContactInfo() + " already exists");
        }

        if (updatedSeller.getName() == null || updatedSeller.getContactInfo() == null) {
            throw new InvalidSellerInfoException("Seller name and email cannot be empty");
        }
        updatedSeller.setId(existingSeller.getId());
        return sellerRepository.save(updatedSeller);
    }


    public void deleteSeller(int id) {
        Seller seller = getSellerById(id);
        sellerRepository.delete(seller);
    }
}
