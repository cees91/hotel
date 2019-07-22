package com.hotelcalifornia.hotel.controllers;


import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * This is the Booking controller.
 * It can be used to find bookings, show a list of bookings, save new bookings or edit bookings.
 */
@RestController()
@RequestMapping("bookings")
public class BookingController {
    /**
     * searches for a booking in the registered list by booking id
     * @param id the id of the booking
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     * TODO don't return null, throw an exception
     */
    @GetMapping("bookingId={id}")
    public Booking getBookingFromRepository(@PathVariable long id) {
        System.out.println("get by id");
        return BookingRepository.getInstance().findBooking(id);
    }

    /**
     * searches for a booking in the registered list by username
     * @param userName the username of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     */
    @GetMapping("userName={userName}")
    public Booking getBookingFromRepository(@PathVariable String userName) {
        System.out.println("get by username");
        return BookingRepository.getInstance().findBooking(userName);
    }

    /**
     * searches for a booking in the registered list by first AND last name
     * @param firstName the first name of the headbooker
     * @param lastName the last name of the headbooker
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     */
    @GetMapping("?firstName={firstName}&lastName={lastName}")
    public Booking getBookingFromRepository(@PathVariable String firstName,@PathVariable String lastName) {
        System.out.println("get by full name");
        return BookingRepository.getInstance().findBooking(firstName, lastName);
    }

    /**
     * Get the entire list of bookings currently registered in the repository
     * @return a list of booking objects, can be empty
     */
    @GetMapping
    public List<Booking> getAllBookings() {
        System.out.println("empty get");
        return BookingRepository.getInstance().getBookings();
    }

    /**
     * create and add a new booking to the booking repository
     * @param booking a booking object, for POST calls, use JSON to create a valid booking object.
     * TODO: create something that checks the validity of the booking object and returns if you are allowed to create an object or not
     */
    @PostMapping
    public void saveBooking(@RequestBody Booking booking) {
        BookingRepository bookingRepo = BookingRepository.getInstance();
        bookingRepo.create(booking);
    }

    /**
     * overwrite the booking that has the given id, with a new booking object constructed from the JSON body the PATCH call should provide
     * @param id the id of the booking to overwrite
     * @param booking an automatically constructed booking object from the provided JSON body
     */
    @PatchMapping("bookingId={id}")
    public void patchBooking(@PathVariable long id, @RequestBody Booking booking) {
        BookingRepository.getInstance().findAndUpdate(id, booking);
    }

    /**
     * remove a booking from the booking repository
     * @param id the id of the booking to delete
     * TODO: return something when successful or not
     */
    @DeleteMapping("bookingId={id}")
    public void deleteBooking(@PathVariable long id) {
        BookingRepository.getInstance().deleteBooking(id);
    }
}
