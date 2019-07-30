package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.exceptions.BadRequestException;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.repository.RoomRepository;
import com.hotelcalifornia.hotel.utils.CSVReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/rooms")
public class RoomController {

    private ArrayList<Room> rooms;

    public RoomController() {
        this.rooms = readCSVFile();
    }

    @GetMapping(params = "roomID")
    public Room getRoomByID(@RequestParam("roomID") int id) {
        Room room = null;
        try {
            room = RoomRepository.getInstance().findRoom(id);
        } catch (Exception error) {
            System.out.println(error);
        }
        return room;
    }

    @GetMapping()
    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = null;
        try {
            rooms = RoomRepository.getInstance().getRooms();
        } catch (Exception error) {
            System.out.println(error);
        }
        return rooms;
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        List<Room> rooms = null;
        try {
            rooms = RoomRepository.getInstance().getAvailableRooms();
        } catch (Exception error) {
            System.out.println(error);
        }
        return rooms;
    }

    @GetMapping(params = "roomType")
    public List<Room> findRooms(@RequestParam("roomType") String roomType) {
        List<Room> rooms = null;
        try {
            rooms = RoomRepository.getInstance().findRoom(roomType);
        } catch (Exception error) {
            System.out.println(error);
        }
        return rooms;
    }

    @GetMapping(params = "numberOfPeople")
    public List<Room> findRooms(@RequestParam("numberOfPeople") int numberOfPeople) {
        List<Room> rooms = null;
        try {
            rooms = RoomRepository.getInstance().filterRoomsByPeople(numberOfPeople);
        } catch (Exception error) {
            System.out.println(error);
        }
        return rooms;
    }

    @GetMapping(params = {"adults", "start", "end"})
    public ArrayList<Room> findRooms(@RequestParam("adults") int adults, @RequestParam("start") String start, @RequestParam("end") String end) {
        ArrayList<Room> rooms;
        try {
            rooms = RoomRepository.getInstance().findAvailableRooms(adults, start, end);
        } catch (ParseException error) {
            throw new BadRequestException("Something went wrong with the supplied dates.");
        } catch (Exception error) {
            throw new BadRequestException("Couldn't find any rooms with the supplied data.");
        }
        return rooms;
    }

    private ArrayList<Room> readCSVFile() {
        CSVReader reader = new CSVReader();
        ArrayList<Room> csvRooms = reader.csvReader();

        return csvRooms;
    }


}
