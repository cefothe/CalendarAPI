package eu.stefanangelov.room.persistence.entity;

import java.util.Set;
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
    private Set<Availability> availabilities;

    public void addAvailability(Availability availability){
        availabilities.add(availability);
    }
}
