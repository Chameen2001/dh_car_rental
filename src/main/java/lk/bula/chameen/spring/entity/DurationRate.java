package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "durationRate")
public class DurationRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int dailyRate;
    private int monthlyRate;
}
