package lk.bula.chameen.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentalDTO {
    private String id;
    private int startMillage;
    private int endMillage;
    private ReservationDTO reservationDTO;
    private AdminDTO adminDTO;


}
