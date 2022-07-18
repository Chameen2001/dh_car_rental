package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
}
