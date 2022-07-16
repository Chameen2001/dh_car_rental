package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "maintenance")
public class Maintenance {

    @Id
    private String id;
    private LocalDate date;
    private int millage;
    private double serviceCharge;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "carId",referencedColumnName = "regNo")
    private Car car;
}
