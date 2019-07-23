package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.Enums.ERoomType;
import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.repository.RoomRepository;
import com.hotelcalifornia.hotel.utils.CSVReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
@RestController()
@RequestMapping("api/rooms")
public class RoomController {

    private ArrayList<Room> rooms;


    public RoomController() {
        this.rooms = readCSVFile();
    }

    @GetMapping(params = "roomID")
    public Room getRoomByID(@RequestParam("roomID") int id){
        Room room = null;
        try {
            room = RoomRepository.getInstance().findRoom(id);
        } catch(Exception error){
            System.out.println(error);
        }
        return room;
    }
    @GetMapping()
    public ArrayList<Room> getAllRooms(){
        ArrayList<Room> rooms = null;
        try {
            rooms = RoomRepository.getInstance().getRooms();
        } catch(Exception error){
            System.out.println(error);
        }
        return rooms;
    }
    private ArrayList<Room> readCSVFile() {
        CSVReader reader = new CSVReader();
        ArrayList<Room> csvRooms = reader.csvReader();

            return csvRooms;
        }

        ;
        public Booking bookRooms (Booking newBooking){
            ERoomType roomType = showRoomTypes(newBooking);
            boolean isAvailable = checkRoomAvailability(roomType, newBooking);
            if (isAvailable) {
                return newBooking;
            }
            return null;
        }
        private ERoomType showRoomTypes (Booking newBooking){
            String types = "";
            int i = 1;
            for (ERoomType currentType : ERoomType.values()) {
                types += i + ": " + currentType.name() + "\n";
                i++;
            }
            Scanner terminal = new Scanner(System.in);
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println(types);
            ERoomType roomType = ERoomType.values()[Integer.parseInt(terminal.nextLine())];
            return roomType;
        }

        private boolean checkRoomAvailability (ERoomType type, Booking currentBooking){
            int i = 1;
            Room[] rooms = new Room[100];
            int numberOfGuests = currentBooking.getNumberOfGuests();
            for (Room currentRoom : this.rooms) {
                if (currentRoom.isAvailable() && currentRoom.getType() == type && numberOfGuests > 0) {
                    numberOfGuests -= currentRoom.getAdults();
                    rooms[i] = currentRoom;
                    i++;
                }
            }
            currentBooking.setBookedRooms(rooms);
            if (numberOfGuests == 0) {
                return true;
            }
            return false;
        }


    }
