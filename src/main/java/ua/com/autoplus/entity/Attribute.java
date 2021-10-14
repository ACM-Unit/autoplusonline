package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="AP_ATTRIBUTES")
public class Attribute {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer attrId;
    private String name;
    private String type;

}
