package ua.com.autoplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Data
@Table(name = "AP_PARTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String slug;
    private String code;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name="trademark_id")
    private Trademark trademark;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="part_id")
    private List<Parameter> parameters;
}
