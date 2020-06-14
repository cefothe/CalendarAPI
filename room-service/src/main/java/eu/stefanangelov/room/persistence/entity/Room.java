package eu.stefanangelov.room.persistence.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Room extends BaseEntity {
    private String name;
    @ElementCollection
    private List<Availability> availabilities;
}
