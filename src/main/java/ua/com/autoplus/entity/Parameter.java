package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "AP_PARAMS")
@Data
@Entity
public class Parameter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="attr_id")
    private Attribute attribute;

    @Column(name="part_id", insertable=false, updatable=false)
    private Integer partId;
    private String value;
    private Integer showOrder;

}
