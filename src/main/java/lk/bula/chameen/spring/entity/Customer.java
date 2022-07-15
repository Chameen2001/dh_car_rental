package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name = "customer")
public class Customer {
    @Id
    private String id;
    private String nic;
    private String drivingId;
    private String name;
    private String address;
    private double salary;
    private String email;
    private String password;
}
