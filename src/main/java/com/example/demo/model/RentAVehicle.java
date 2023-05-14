package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class RentAVehicle {
    @Id
    @SequenceGenerator(
            name = "rentavehicle_sequence",
            sequenceName = "rentavehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "rentavehicle_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private Long idUser;
    @NotBlank
    @Column(nullable = false)
    private Long idVehicle;
    @NotBlank
    @Column(nullable = false)
    private Timestamp rentDate;
    @NotBlank
    @Column(nullable = false)
    private Timestamp returnDate;
}
