package com.example.phonesAPI.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="phone")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},
        allowGetters=true)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="make")
    private String make;

    @Column(name="color")
    private String color;

    @Column(name="model")
    private String model;

    @Column(name="price")
    private int price;

    public Phone(String make, String color, String model, int price) {
        this.make = make;
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public Phone() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

