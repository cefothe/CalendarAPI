package eu.stefanangelov.event.persistence.repository;

import eu.stefanangelov.event.persistence.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    boolean existsByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqualAndRoomId(LocalDateTime from, LocalDateTime to, String id);
    Optional<Boolean> existsByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqualAndParticipantsId(LocalDateTime from, LocalDateTime to, String id);
    List<Event> findAllByAvailabilityFromDateLessThanEqualAndAvailabilityToDateGreaterThanEqual(LocalDateTime from, LocalDateTime to);
}

