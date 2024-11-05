package com.org.mailservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "AddressBook")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email_addresses", nullable = false)
    private List<String> email_addresses;
}
