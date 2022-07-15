package lk.bula.chameen.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Transactional
public class CarDTO {
    private String regNo;
}
