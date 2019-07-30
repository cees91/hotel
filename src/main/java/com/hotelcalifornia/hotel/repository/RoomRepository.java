package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Enums.ERoomType;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.utils.CSVReader;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoomRepository {
    private static RoomRepository instance = null;
    private ArrayList<Room> rooms;

    private RoomRepository() {
        CSVReader reader = new CSVReader();
        this.rooms = reader.csvReader();
    }

    private Room filterRooms(int roomNumber) {
        Room room = null;
        for (Room currentRoom : this.rooms) {
            if (currentRoom.getRoomNumber() == (roomNumber)) {
                room = currentRoom;
                break;
            }
        }
        return room;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = this.rooms.stream().filter(room -> room.isAvailable()).collect(Collectors.toList());

        return availableRooms;
    }

    public Room findRoom(int roomNumber) throws Exception {
        Room room = filterRooms(roomNumber);
        if (room != null) {
            return room;
        } else {
            throw new Exception("Room not found!");
        }
    }

    public List<Room> findRoom(String roomType) throws Exception {
        List<Room> rooms = this.
                rooms.
                stream().
                filter(currentRoom -> ERoomType.valueOf(roomType) == currentRoom.getType())
                .collect(Collectors.toList());
        return rooms;
    }

    public List<Room> filterRoomsByPeople(int numberOfPeople) {
        List<Room> rooms = this.
                rooms.
                stream().
                filter(currentRoom -> (currentRoom.getAdults() + currentRoom.getChildren()) >= numberOfPeople)
                .collect(Collectors.toList());
        return rooms;
    }

    public ArrayList<Room> findAvailableRooms(int numberOfAdults, String start, String end) throws ParseException {
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(start);
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(end);
        ArrayList<Room> foundRooms = new ArrayList<>();
        for (Room currentRoom : this.rooms) {
            if (currentRoom.getAdults() >= numberOfAdults && (currentRoom.getStartDate() == null || currentRoom.getStartDate().before(startDate)) && (currentRoom.getEndDate() == null || currentRoom.getEndDate().after(endDate)) )
            {
                foundRooms.add(currentRoom);
            }
        }
        return foundRooms;
    }

    public Room bookRoom(int roomNumber) throws Exception {
        Room room = filterRooms(roomNumber);
        try {
            if (room.isAvailable()) {
                room.setAvailable(false);
            }
        } catch (Exception e) {
            throw new Exception("Room is unavailable for booking");
        }
        return room;
    }

    public Room freeRoom(int roomNumber) throws Exception {
        Room room = filterRooms(roomNumber);
        try {
            if (!room.isAvailable()) {
                room.setAvailable(true);
            }
        } catch (Exception e) {
            throw new Exception("Room is unavailable for booking");
        }
        return room;
    }

    public void cleanRoom(int roomNumber) {
        Room room = filterRooms(roomNumber);
        // room needs a clean getter and setter!
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }
}
