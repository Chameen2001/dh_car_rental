package lk.bula.chameen.spring.dto;

import lk.bula.chameen.spring.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MaintenanceDTO {

    private String id;
    private LocalDate date;
    private int millage;
    private double serviceCharge;
    private Car car;
}
