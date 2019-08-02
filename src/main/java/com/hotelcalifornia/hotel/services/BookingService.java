package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.exceptions.EmptyRepoException;
import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.BookingRepository;
import com.hotelcalifornia.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public void update(Booking b) throws RuntimeException {
        if (bookingRepository.existsById(b.getId())) {
            bookingRepository.save(b);
        } else {
            throw new NotFoundException();
        }
    }

    /**
     * save a new booking
     * @param b the new booking to save
     * @throws DataAccessException thrown when constraints in the table are violated, see documentation for more info
     */
    public void saveNewBooking(Booking b) throws DataAccessException {
        try {
            bookingRepository.save(b);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void deleteBookingById(long id) throws RuntimeException {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new NotFoundException();
        }
    }

    public void deleteBooking(Booking b) throws RuntimeException {
        if (bookingRepository.existsById(b.getId())) {
            bookingRepository.delete(b);
        } else {
            throw new NotFoundException();
        }
    }

    public List<Booking> getBookings() throws RuntimeException {
        if (bookingRepository.count() == 0) {
            throw new EmptyRepoException();
        }
        return bookingRepository.findAll();
    }

    public Booking findBookingById(long id) throws RuntimeException {
        Optional<Booking> b = bookingRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        } else {
            throw new NotFoundException();
        }
    }

    public Booking findBookingByFirstAndLastName(String fname, String lname) throws RuntimeException {
        User u = userRepository.findByFirstNameAndLastName(fname, lname);
        if(!userRepository.existsById(u.getId())) {
            throw new NotFoundException("User not found.");
        }

        Booking b = bookingRepository.findByUser(u);
        if(!bookingRepository.existsById(b.getId())) {
            throw new NotFoundException("Booking not found.");
        }
        return b;
    }

    public Booking findBookingByUserName(String uname) throws RuntimeException {
        User u = userRepository.findByUserName(uname);
        if(!userRepository.existsById(u.getId())) {
            throw new NotFoundException("User not found.");
        }

        Booking b = bookingRepository.findByUser(u);
        if(!bookingRepository.existsById(b.getId())) {
            throw new NotFoundException("Booking not found.");
        }
        return b;
    }

    public List<Booking> getAllbookingsForAGuest(User u) throws RuntimeException {
        List<Booking> lb = bookingRepository.findAllByUser(u);
        if(lb.isEmpty()) {
            throw new NotFoundException();
        }
        return lb;
    }
}
