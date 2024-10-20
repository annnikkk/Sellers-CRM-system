package org.example.test_shift.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @NotBlank(message = "Contact info can't be empty")
    @Email(message = "Please enter a valid email address")
    private String contactInfo;

    @CreationTimestamp
    private LocalDateTime registrationDate;
}
