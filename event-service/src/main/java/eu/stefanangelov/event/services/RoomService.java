package eu.stefanangelov.event.services;

import eu.stefanangelov.event.persistence.entity.Room;
import eu.stefanangelov.event.persistence.repository.RoomRepository;
import eu.stefanangelov.event.services.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public void createUpdate(RoomDTO roomDTO) {
        roomRepository.findById(roomDTO.getId())
            .ifPresentOrElse(room -> {
                room.setName(roomDTO.getName());
                roomRepository.save(room);
            },()->{
              var room = new Room(roomDTO.getId(),roomDTO.getName());
              roomRepository.save(room);
            });
    }
}
