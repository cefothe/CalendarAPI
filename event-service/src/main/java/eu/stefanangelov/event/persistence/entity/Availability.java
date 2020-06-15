package eu.stefanangelov.event.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Embeddable
public class Availability {
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
