package ua.com.autoplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;

  private String title;
  private String reference;
  @Column(name="parent_id", insertable=false, updatable=false)
  private Integer parentId;

  @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
  @JoinColumn(name="parent_id")
  private List<Category> children;

  @ManyToMany(cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
  })
  @JoinTable(name = "ap_category_attr",
          joinColumns = @JoinColumn(name = "category_id"),
          inverseJoinColumns = @JoinColumn(name = "attr_id")
  )
  private List<Attribute> attributes;
}
