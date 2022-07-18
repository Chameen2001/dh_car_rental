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
@Entity(name = "reservation")
public class Reservation {
    @Id
    private String id;
    private LocalDate date;
    private int dateOfNeeded;
    private LocalDate dateOfNeed;

    @ManyToOne(cascade ={CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "carRegNo", referencedColumnName = "regNo")
    private Car car;


}
