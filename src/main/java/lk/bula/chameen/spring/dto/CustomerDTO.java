package lk.bula.chameen.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data //apply getter and setter
@ToString
public class CustomerDTO {
    private String id;
    private String drivingId;
    private String name;
    private int phoneNo;
    private String email;
}
