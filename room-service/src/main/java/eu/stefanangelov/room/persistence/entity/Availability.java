package eu.stefanangelov.room.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Embeddable
public class Availability {
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
