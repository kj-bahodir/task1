package uz.pdp.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.Room;
import uz.pdp.task1.repository.RoomRepository;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/{id}")
    public Page<Room> getRoomsById(@PathVariable Integer id, @RequestParam int page){
        Pageable pageable=PageRequest.of(page,10);
        Page<Room> roomPage = roomRepository.findAllByHotelId(id,pageable);
        return roomPage;
    }

}
