package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.exceptions.BadRequestException;
import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.repository.RoomRepository;
import com.hotelcalifornia.hotel.services.RoomService;
import com.hotelcalifornia.hotel.utils.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService service;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addrooms(@RequestBody List<Room> rooms){
        service.addRooms(rooms);
    }
    @RequestMapping(value = "/id", method = RequestMethod.GET, params = "roomID")
    public Room getRoomByID(@RequestParam("roomID") int id) {
        Room room = null;
        try {
            room = service.findRoom(id);
        } catch (Exception error) {
            System.out.println(error);
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
            rooms = service.getRooms();
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

    /**
     * Finds the rooms that have not been booked yet
     * @param adults
     * @param startDate
     * @param endDate
     * @return
     */
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
