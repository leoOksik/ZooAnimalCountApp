package com.example.zooanimalcountapp.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="animal_t")
@Data
@NoArgsConstructor

public class ZooAnimalDto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="name_animal", nullable = false)
    private String name;

    @Column(name="kind_animal", nullable = false)
    private String kind;

    @Column(name="count_animal", nullable = false)
    private String count;
}
