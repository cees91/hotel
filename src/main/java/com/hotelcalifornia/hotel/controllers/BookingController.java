package com.hotelcalifornia.hotel.controllers;


import com.hotelcalifornia.hotel.exceptions.EmptyRepoException;
import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * This is the Booking controller.
 * It can be used to find bookings, show a list of bookings, save new bookings or edit bookings.
 */
@RestController()
@RequestMapping("api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    /**
     * searches for a booking in the registered list by booking id
     *
     * @param id the id of the booking
     * @return the found {@link Booking}
     * @throws NotFoundException
     */
    @GetMapping(params = "bookingId")
    public Booking getBookingFromRepository(@RequestParam("bookingId") long id) throws RuntimeException {
        System.out.println("get by id");
        try {
            return bookingService.findBooking(id);
        } catch (NotFoundException e) {
            throw e;
        }

    }

    /**
     * searches for a booking in the registered list by username
     *
     * @param userName the username of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     */
//    @GetMapping(params = "userName")
//    public Booking getBookingFromRepository(@RequestParam("userName") String userName) throws RuntimeException {
//        System.out.println("get by username");
//        try {
//            return bookingService.findBooking(userName);
//        } catch (NotFoundException e) {
//            throw e;
//        }
//    }

    /**
     * searches for a booking in the registered list by first AND last name
     *
     * @param firstName the first name of the headbooker
     * @param lastName  the last name of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     */
//    @GetMapping(params = {"firstName", "lastName"})
//    public Booking getBookingFromRepository(@RequestParam("firstName") String firstName,
//                                            @RequestParam("lastName") String lastName) throws RuntimeException {
//        System.out.println("get by full name");
//        try {
//            return bookingService.findBooking(firstName, lastName);
//        } catch (NotFoundException e) {
//            throw e;
//        }
//    }

    /**
     * Get the entire list of bookings currently registered in the repository
     *
     * @return a list of booking objects
     * @throws EmptyRepoException throws an exception when nothing is saved in the repo
     */
    @GetMapping
    public List<Booking> getAllBookings() throws RuntimeException {
        System.out.println("empty get");
        try {
            return bookingService.getBookings();
        } catch (EmptyRepoException e) {
            throw e;
        }
    }

    /**
     * create and add a new booking to the booking repository
     *
     * @param booking a booking object, for POST calls, use JSON to create a valid booking object.
     * TODO: create something that checks the validity of the booking object and returns if you are allowed to create an object or not
     */
    @PostMapping
    public void saveBooking(@RequestBody Booking booking) {

        bookingService.create(booking);
    }

    /**
     * overwrite the booking that has the given id, with a new booking object constructed from the JSON body the PATCH call should provide
     *
     * @param id      the id of the booking to overwrite
     * @param booking an automatically constructed booking object from the provided JSON body
     */
    @PatchMapping(params = "bookingId")
    public void patchBooking(@RequestParam("bookingId") long id, @RequestBody Booking booking) throws RuntimeException {
        try {
            bookingService.findAndUpdate(id, booking);
        } catch (NotFoundException e) {
            throw e;
        }
    }

    /**
     * remove a booking from the booking repository
     *
     * @param id the id of the booking to delete
     *           TODO: return something when successful or not
     */
    @DeleteMapping(params = "bookingId")
    public void deleteBooking(@RequestParam("bookingId") long id) throws RuntimeException {
        try {
            bookingService.deleteBooking(id);
        } catch (NotFoundException e) {
            throw e;
        }
    }
}
