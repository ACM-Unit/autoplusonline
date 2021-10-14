package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Trademark")
public class Trademark {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer id;
    public String description;
    public String slug;
    @Column(name="is_checked")
    public Boolean checked;
    @Column(name="is_archive")
    public Boolean archived;
}
