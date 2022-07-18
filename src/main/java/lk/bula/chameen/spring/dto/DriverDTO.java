package lk.bula.chameen.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;
}
