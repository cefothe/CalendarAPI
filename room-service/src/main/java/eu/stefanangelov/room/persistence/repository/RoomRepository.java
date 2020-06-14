package eu.stefanangelov.room.persistence.repository;

import eu.stefanangelov.room.persistence.entity.Room;
import eu.stefanangelov.room.services.dto.RoomDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

    List<Room> findAllByAvailabilitiesFromDateLessThanEqualAndAvailabilitiesToDateGreaterThanEqual(
        LocalDateTime from, LocalDateTime to);
}
