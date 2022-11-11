package lk.bula.chameen.spring.entity;

import lk.bula.chameen.spring.util.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "car")
public class Car {
    @Id
    private String regNo;

    private String type;

    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @Enumerated(EnumType.STRING)
    private CarModel model;

    private int noOfPassenger;

    @Enumerated(EnumType.STRING)
    private Transmission transmissionType;

    private String fuelType;
    private int millage;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "rateId",referencedColumnName = "id")
    DurationRate rate;

    private double priceForExKm;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String frontImage;
    private String backImage;

}
