package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name = "rental")
public class Rental {
    @Id
    private String id;
    private int startMillage;
    private int endMillage;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "reservationId", referencedColumnName = "id")
    private Reservation reservation;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "adminId", referencedColumnName = "id")
    private Admin admin;


}
