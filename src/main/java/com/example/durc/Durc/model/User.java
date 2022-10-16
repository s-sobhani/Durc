package com.example.durc.Durc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "User")
public class User {
//sequence for ID Starts from here.....................
//...................................................
//.................................................

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
    private String id;

    //...................................................
    //.....................................................
    //ID sequence END HERE...................................

    @Column(
            name = "name",
            nullable = false,
            updatable = true
    )
    private String name;

    @Column(
            name = "email",
            unique = true,
            nullable = false,
            updatable = false,
            length = 100
    )
    private String email;

    @Column(
            name = "Date",
            nullable = false,
            updatable = false
    )
    Date date = new Date();

    public User(String id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
