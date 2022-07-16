package lk.bula.chameen.spring.dto;

import lk.bula.chameen.spring.entity.DurationRate;
import lk.bula.chameen.spring.util.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String regNo;
    private CarBrand brand;
    private CarModel model;
    private int noOfPassenger;
    private Transmission transmissionType;
    private String fuelType;
    private int millage;
    private DurationRate rate;
    private double priceForExKm;
    private Color color;
    private Status status;
}
