package com.example.durc.Durc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ImageData")
public class ImageData {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(name = "imageData", length=1000)
    private byte[] imageData;
}
