package eu.stefanangelov.room.controller;

import eu.stefanangelov.common.kafka.dto.RoomDTO;
import eu.stefanangelov.room.services.RoomService;
import eu.stefanangelov.room.services.dto.CreateUpdateRoomDTO;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomDTO> roomsGet(@Valid @RequestParam(value = "from") LocalDateTime from
        ,@Valid @RequestParam(value = "to") LocalDateTime to){
        return roomService.getRooms(from, to);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@Validated @RequestBody CreateUpdateRoomDTO roomDTO){
        return new ResponseEntity<>(roomService.createRoom(roomDTO), HttpStatus.CREATED);
    }
}
