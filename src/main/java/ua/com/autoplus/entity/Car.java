package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Car")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private String type;
    private String reference;
    private String year;

}
