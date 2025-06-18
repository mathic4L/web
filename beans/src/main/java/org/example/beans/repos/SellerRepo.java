package org.example.beans.repos;

import org.example.beans.pojos.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
}
