package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name="ap_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Account account;
}
