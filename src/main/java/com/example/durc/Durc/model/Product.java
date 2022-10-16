package com.example.durc.Durc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")

public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "uuid2"
    )
    @GenericGenerator(
            name = "uuid2",
            strategy = "uuid2"
    )
    private String pd_id;

    @Column(
            name = "name",
            nullable = false,
            updatable = true
    )
    private String pd_name;

    @Column(
            name = "quantity",
            nullable = false,
            updatable = true
    )
    private int quantity;

}
