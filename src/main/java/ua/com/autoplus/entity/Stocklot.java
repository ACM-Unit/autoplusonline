package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ap_stocklot")
public class Stocklot {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="part_id")
    private Part part;
    private int quantity;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;
    private String price;
}
