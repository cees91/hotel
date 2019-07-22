package com.hotelcalifornia.hotel.controllers;


import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebInitParam;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is the Booking controller.
 * It can be used to find bookings, show a list of bookings and update values in the bookings.
 */
@RestController()
@RequestMapping("bookings")
public class BookingController {
    /**
     * searches for a booking in the registered list
     * @param id the id of the booking
     * @return the {@link Booking} or null, returns a booking when successful, null when not
     * TODO don't return null, throw an exception
     */
    @GetMapping("show_one={id}")
    public Booking getBookingFromRepository(@PathVariable long id) {
        return BookingRepository.getInstance().findBooking(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return BookingRepository.getInstance().getBookings();
    }

    @PostMapping
    public void saveBooking(@RequestBody Booking booking) {
        BookingRepository bookingRepo = BookingRepository.getInstance();
        bookingRepo.create(booking);
    }
}
