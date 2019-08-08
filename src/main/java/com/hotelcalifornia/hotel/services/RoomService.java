package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.Enums.ERoomType;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repo;

    public Room findRoom(long roomNumber) throws Exception {
        Room room = filterRooms(roomNumber);
        if (room != null) {
            return room;
        } else {
            throw new Exception("Room not found!");
        }
    }

    private Room filterRooms(long roomNumber) {
        Room room = null;
        for (Room currentRoom : repo.findAll()) {
            if (currentRoom.getRoomNumber() == (roomNumber)) {
                room = currentRoom;
                break;
            }
        }
        return room;
    }

    public List<Room> findRoom(String roomType) throws Exception {
        List<Room> rooms = this.
                repo.findAll().
                stream().
                filter(currentRoom -> ERoomType.valueOf(roomType) == currentRoom.getType())
                .collect(Collectors.toList());
        return rooms;
    }

    public List<Room> filterRoomsByPeople(int numberOfPeople) {
        List<Room> rooms = this.
                repo.findAll().
                stream().
                filter(currentRoom -> (currentRoom.getAdults() + currentRoom.getChildren()) >= numberOfPeople)
                .collect(Collectors.toList());
        return rooms;
    }

    public ArrayList<Room> findAvailableRooms(int numberOfAdults, LocalDate startDate, LocalDate endDate) {

        ArrayList<Room> foundRooms = new ArrayList<>();
        for (Room currentRoom : repo.findAll()) {
            if (checkDates(currentRoom, numberOfAdults, startDate, endDate)) {
                foundRooms.add(currentRoom);
            }
        }
        return foundRooms;
    }

    public ArrayList<Room> getAllRooms() {
        return repo.findAll();
    }

    public void addRooms(List<Room> rooms) {
        repo.saveAll(rooms);
    }

    public void addRoom(Room room) {
        repo.save(room);
    }

    public void deleteRoomById(long id) {
        repo.deleteById(id);
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = repo.findAll().stream().filter(room -> room.isAvailable()).collect(Collectors.toList());
        ;
        return availableRooms;
    }

    private boolean checkDates(Room currentRoom, int numberOfAdults, LocalDate startDate, LocalDate endDate) {
        if ((currentRoom.getStartDate() == null && currentRoom.getEndDate() == null
                || (currentRoom.getStartDate().isAfter(startDate) && currentRoom.getStartDate().isAfter(endDate))
                || (currentRoom.getEndDate().isBefore(startDate) && currentRoom.getEndDate().isBefore(endDate)))) {
            return true;
        }
        return false;
    }

    public void bookRoom(Room room) {
        repo.save(room);
    }


}
