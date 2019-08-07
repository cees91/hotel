package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.exceptions.BadRequestException;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService service;


    @RequestMapping(value = "new", method = RequestMethod.POST)
    public void addRoom(@RequestBody Room room){
         service.addRoom(room);
    }


    @RequestMapping(value = "", method = RequestMethod.DELETE, params = "roomId")
    public void deleteRoom(@RequestParam("roomId") long id) {
        service.deleteRoomById(id);
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET, params = "roomId")
    public Room getRoomByID(@RequestParam("roomId") long id) {
        Room room = null;
        try {
            room = service.findRoom(id);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return room;
    }

    @RequestMapping(value = "/bookroom", method = RequestMethod.POST)
    public void bookRoom(@RequestBody Room room ){
        service.bookRoom(room);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = null;
        try {
            rooms = service.getAllRooms();
        } catch (Exception error) {
            System.out.println(error);
        }
        return rooms;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ArrayList<Room> editRooms(@RequestBody ArrayList<Room> rooms){
        service.addRooms(rooms);
        return rooms;
    }



    @RequestMapping(value = "/findrooms", method = RequestMethod.GET)
    public ArrayList<Room> findRooms(@RequestParam("adults") int adults, @RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(pattern="dd/MM/yyyy") LocalDate endDate) {
        ArrayList<Room> rooms;
        if(startDate.isBefore(endDate)) {
            try {
                rooms = service.findAvailableRooms(adults, startDate, endDate);
            } catch (Exception error) {
                throw new BadRequestException("Couldn't find any rooms with the supplied data." + error);
            }
            return rooms;
        } else{
            throw new BadRequestException("Please select an end date that comes after the start date.");
        }
    }



}
