package eu.stefanangelov.room.services;

import eu.stefanangelov.room.persistence.entity.Room;
import eu.stefanangelov.room.persistence.repository.RoomRepository;
import eu.stefanangelov.room.services.dto.CreateUpdateRoomDTO;
import eu.stefanangelov.room.services.dto.RoomDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomDTO> getRooms(LocalDateTime from, LocalDateTime to) {
        return  roomRepository.findAllByAvailabilitiesFromDateLessThanEqualAndAvailabilitiesToDateGreaterThanEqual(from,to)
            .stream()
            .map(room -> new RoomDTO(UUID.fromString(room.getId()), room.getName()))
            .collect(Collectors.toList());
    }

    public RoomDTO createRoom(CreateUpdateRoomDTO roomDTO) {
        var room = roomRepository.save(new Room(roomDTO.getName(), new ArrayList<>()));
        return new RoomDTO(UUID.fromString(room.getId()), room.getName());
    }
}
