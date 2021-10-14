package ua.com.autoplus.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Modification")
public class Modification {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "parent")
    private Car car;
    private String name;
    @Column(name = "enginetype")
    private String enginetype;
    @Column(name = "enginemodel")
    private String enginemodel;
    @Column(name = "enginecapacity")
    private String enginecapacity;
    @Column(name = "power")
    private String power;
    @Column(name = "drive")
    private String drive;
    @Column(name = "date")
    private String date;
    @Column(name = "reference")
    private String reference;
    @Column(name = "description")
    private String description;
    @Column(name = "startyear")
    private String startYear;
    @Column(name = "endYear")
    private String endYear;
    @Column(name = "bodytype")
    private String bodyType;
    @Column(name = "drivetype")
    private String driveType;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "capacitytax")
    private String capacityTax;
    @Column(name = "capacitytech")
    private String capacityTech;
    @Column(name = "fuelmixture")
    private String fuelMixture;
    @Column(name = "fueltype")
    private String fuelType;
    @Column(name = "numberofcylinders")
    private String numberOfCylinders;
    @Column(name = "numberofvalves")
    private String numberOfValves;
    @Column(name = "constructioninterval")
    private String constructionInterval;
    @Column(name = "enginecode")
    private String engineCode;
    @Column(name = "startyearmonth")
    private String startYearMonth;
    @Column(name = "endyearmonth")
    private String endYearMonth;
}
