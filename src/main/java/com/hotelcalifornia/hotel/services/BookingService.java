package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.exceptions.EmptyRepoException;
import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Finds and returns an arraylist of bookings. Can have null
     * @param bookings {@link Booking}
     * @return ArrayList of bookings
     */
    public ArrayList<Booking> findBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> bookingsList = new ArrayList<>();
        Booking foundBooking = null;
        for (Booking currentBooking : bookingRepository.findAll()) {
            foundBooking = bookings.stream()
                    .filter(x -> currentBooking.getId() == x.getId())
                    .findAny()
                    .orElse(null);
            if (foundBooking != null) {
                bookingsList.add(foundBooking);
            }
        }
        return bookingsList;
    }

    /**
     * Finds and returns an arraylist of bookings.
     * @param idList a list of ids to search on
     * @return an ArrayList of bookings containing the found bookings, if none are found an exception is thrown
     */
    /*  TODO: it might be nice to reuse the findBooking function we already have,
         but i don't know which one is more efficient, .contains() or our own function
     */
    public ArrayList<Booking> findBookings(List<Long> idList) throws RuntimeException {
        ArrayList<Booking> foundBookingsList = new ArrayList<>();
        for (Booking currentBooking : bookingRepository.findAll()) {
            if (idList.contains(currentBooking.getId())) {
                // currentBooking id is in the given idList, add it to the foundBookingsList
                foundBookingsList.add(currentBooking);
            }
        }
        if(foundBookingsList.isEmpty()) {
            throw new NotFoundException();
        }
        return foundBookingsList;
    }

    /**
     * Finds a single booking by id
     * @param id of the booking
     * @return a {@link Booking} or null when unsuccessful
     */
    public Booking findBooking(long id) throws RuntimeException {
        for (Booking currentBooking : bookingRepository.findAll()) {
            if (currentBooking.getId() == id) {
                return currentBooking;
            }
        }
        throw new NotFoundException();
    }

    /**
     * Find a single booking by user name
     *
     * @param userName the username of the headbooker
     * @return a {@link Booking} or null when unsuccessful
     */
//    public Booking findBooking(String userName) throws RuntimeException {
//        for (Booking currentBooking : bookingRepository.findAll()) {
//            if (currentBooking.getHeadBooker().getUserName().equals(userName)) {
//                return currentBooking;
//            }
//        }
//        throw new NotFoundException();
//    }

    /**
     * Find a single booking by first AND last name
     *
     * @param firstName the first name of the headbooker
     * @param lastName  the last name of the headbooker
     * @return a {@link Booking} or null when unsuccessful
     */
//    public Booking findBooking(String firstName, String lastName) throws RuntimeException {
//        for (Booking currentBooking : bookingRepository.findAll()) {
//            if (currentBooking.getHeadBooker().getFirstName().equals(firstName) &&
//                    currentBooking.getHeadBooker().getLastName().equals(lastName)) {
//                return currentBooking;
//            }
//        }
//        throw new NotFoundException();
//    }

    /**
     * finds a booking by id and update it with the given booking
     * @param id the booking id of the booking to update
     * @param booking a new booking object to replace the old one
     */
    public void findAndUpdate(long id, Booking booking) throws RuntimeException {
        Booking foundBooking;
        try {
            foundBooking = findBooking(id);
        } catch (NotFoundException e) {
            throw e;
        }
        // set the id of the newly created booking to the id of the old booking
        booking.setId(id);
        // and overwrite old booking with new booking
        bookingRepository.findAll().set(bookingRepository.findAll().indexOf(foundBooking),booking);
    }

    public ArrayList<Booking> findMultipleBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> foundBookings = findBookings(bookings);
        return foundBookings;
    }

    public void create(Booking booking) {
        bookingRepository.findAll().add(booking);
    }

    public void update(Booking booking) throws RuntimeException {
        long id = booking.getId();
        try {
            findAndUpdate(id, booking);
        } catch (NotFoundException e) {
            throw e;
        }
    }

    public void deleteBooking(long id) throws RuntimeException {
        try {
            bookingRepository.findAll().remove(findBooking(id));
        } catch (NotFoundException e) {
            throw e;
        }


    }

    public List<Booking> getBookings() throws RuntimeException {
        if(bookingRepository.findAll().isEmpty()) {
            throw new EmptyRepoException();
        }
        return bookingRepository.findAll();
    }
}
