package eu.stefanangelov.event.persistence.repository;

import eu.stefanangelov.event.persistence.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
