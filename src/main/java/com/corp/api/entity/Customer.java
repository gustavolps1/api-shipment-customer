package com.corp.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private UUID id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "identity_document")
    private String identityDocument;
}
