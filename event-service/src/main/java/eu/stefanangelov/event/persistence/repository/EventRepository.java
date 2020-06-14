package eu.stefanangelov.event.persistence.repository;

import eu.stefanangelov.event.persistence.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    boolean existsByAvailabilitiesFromDateLessThanEqualAndAvailabilitiesToDateGreaterThanEqualAndRoomId(LocalDateTime from, LocalDateTime to, String id);
}
