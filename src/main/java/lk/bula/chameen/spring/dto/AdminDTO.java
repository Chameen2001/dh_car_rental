package lk.bula.chameen.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String id;
    private String name;
    private int phone;
    private String email;
    private String password;

    public AdminDTO(String id) {
        this.id = id;
    }
}
