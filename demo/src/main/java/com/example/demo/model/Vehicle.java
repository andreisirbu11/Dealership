package com.example.demo.model;

import com.example.demo.update.Offer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
public class Vehicle implements Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String claSS;
    private Long topSpeed;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getClaSS() {
        return claSS;
    }

    public void setClaSS(String claSS) {
        this.claSS = claSS;
    }

    public Long getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Long topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public void discount() {
        Long newPrice = this.price - 10 * this.price / 100;
        this.setPrice(newPrice);
    }

    @Override
    public void increasePrice() {
        Long newPrice = this.price + 10 * this.price / 100;
        this.setPrice(newPrice);
    }
}
