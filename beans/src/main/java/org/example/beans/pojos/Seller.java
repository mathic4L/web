package org.example.beans.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

// jpa, not spring
@Entity
@Data
public class Seller {
    // required for @Entity
    @Id
    private Long id;
}
