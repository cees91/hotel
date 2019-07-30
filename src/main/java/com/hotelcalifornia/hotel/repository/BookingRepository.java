package com.hotelcalifornia.hotel.repository;


import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {

    private static BookingRepository instance = null;
    EnvironmentSingleton singleton = EnvironmentSingleton.getInstance();
    private ArrayList<Booking> BookingList = new ArrayList<>();

    private BookingRepository() {
        //Read the CSV and bind data to BookingList


    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    /**
     * Finds and returns an arraylist of bookings. Can have null
     * @param bookings {@link Booking}
     * @return ArrayList of bookings
     */
    public ArrayList<Booking> findBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> bookingsList = new ArrayList<>();
        Booking foundBooking = null;
        for (Booking currentBooking : this.BookingList) {
            foundBooking = bookings.stream()
                    .filter(x -> currentBooking.getBookingId() == x.getBookingId())
                    .findAny()
                    .orElse(null);
            if (foundBooking != null) {
                bookingsList.add(foundBooking);
            }
        }
        return bookingsList;
    }

    /**
     * Finds and returns an arraylist of bookings. Can have null
     * @param idList a list of ids to search on
     * @return an ArrayList of bookings containing the found bookings, if none are found, the list returns empty
     */
    /*  TODO: it might be nice to reuse the findBooking function we already have,
         but i don't know which one is more efficient, .contains() or our own function
     */
    public ArrayList<Booking> findBookings(List<Long> idList) {
        ArrayList<Booking> foundBookingsList = new ArrayList<>();
        for (Booking currentBooking : this.BookingList) {
            if (idList.contains(currentBooking.getBookingId())) {
                // currentBooking id is in the given idList, add it to the foundBookingsList
                foundBookingsList.add(currentBooking);
            }
        }
        return foundBookingsList;
    }

    /**
     * Finds a single booking by id
     * @param id of the booking
     * @return a {@link Booking} or null when unsuccessful
     */
    public Booking findBooking(long id) {
        for (Booking currentBooking : this.BookingList) {
            if (currentBooking.getBookingId() == id) {
                return currentBooking;
            }
        }
        return null;
    }

    /**
     * Find a single booking by user name
     *
     * @param userName the username of the headbooker
     * @return a {@link Booking} or null when unsuccessful
     */
    public Booking findBooking(String userName) {
        for (Booking currentBooking : this.BookingList) {
            if (currentBooking.getHeadBooker().getUserName().equals(userName)) {
                return currentBooking;
            }
        }
        return null;
    }

    /**
     * Find a single booking by first AND last name
     *
     * @param firstName the first name of the headbooker
     * @param lastName  the last name of the headbooker
     * @return a {@link Booking} or null when unsuccessful
     */
    public Booking findBooking(String firstName, String lastName) {
        for (Booking currentBooking : this.BookingList) {
            if (currentBooking.getHeadBooker().getFirstName().equals(firstName) &&
                    currentBooking.getHeadBooker().getLastName().equals(lastName)) {
                return currentBooking;
            }
        }
        return null;
    }

    /**
     * finds a booking by id and update it with the given booking
     * @param id the booking id of the booking to update
     * @param booking a new booking object to replace the old one
     */
    public void findAndUpdate(long id, Booking booking) {
        for (Booking currentBooking : this.BookingList) {
            if (currentBooking.getBookingId() == id) {
                // set the id of the newly created booking to the id of the old booking
                booking.setBookingId(id);
                // and overwrite old booking with new booking
                this.BookingList.set(this.BookingList.indexOf(currentBooking),booking);
            }
        }
    }

    public ArrayList<Booking> findMultipleBookings(ArrayList<Booking> bookings) {
        ArrayList<Booking> foundBookings = findBookings(bookings);
        return foundBookings;
    }



    public void update(Booking booking) {
        long id = booking.getBookingId();
        findAndUpdate(id, booking);
    }

    public void deleteBooking(long id) {
        this.BookingList.remove(findBooking(id));
    }

    public ArrayList<Booking> getBookings() {
        return this.BookingList;
    }
}
