package com.kaine.customer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
}
