package lk.bula.chameen.spring.dto;

import lk.bula.chameen.spring.entity.DurationRate;
import lk.bula.chameen.spring.util.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String regNo;
    private CarBrand brand;
    private String type;
    private CarModel model;
    private int noOfPassenger;
    private Transmission transmissionType;
    private String fuelType;
    private int millage;
    private String dailyRT;
    private String monthlyRT;
    private double priceForExKm;
    private Colour colour;
    private Status status;
    private String frontImage;
    private String backImage;
    private DurationRate durationRate;
}
