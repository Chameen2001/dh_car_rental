package lk.bula.chameen.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public DurationRate(int id) {
        this.id = id;
    }
}
