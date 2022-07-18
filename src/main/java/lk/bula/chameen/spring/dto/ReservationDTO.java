package lk.bula.chameen.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data //apply getter and setter
@ToString
public class ReservationDTO {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private int dateOfNeeded;
    private LocalDate dateOfNeed;
    private CustomerDTO customer;
    private CarDTO car;

    public ReservationDTO(String id) {
        this.id = id;
    }
}
