package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EBookingStatus;
import com.hotelcalifornia.hotel.Enums.EPaymentMethod;

import javax.persistence.*;
import java.time.LocalDate;


import static java.lang.Long.MAX_VALUE;

@Entity
@Table(name="Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    // variables regarding payment
    private boolean bookingPayed;
    @Column(columnDefinition = "double DEFAULT 0.0")
    private double price;
    private double amountPayed;

    // the user that booked the room(s)
    private long headBookerId;
    private int numberOfGuests;
    // list of room id's that are booked, comma separated
    private String bookedRooms;
    // enum variables
    @Enumerated(EnumType.ORDINAL)
    private EBookingStatus bookingStatus;
    @Enumerated(EnumType.ORDINAL)
    private EPaymentMethod paymentMethod;
    // dates
    private LocalDate dateStart;
    private LocalDate dateEnd;

    @Column(columnDefinition = "datetime DEFAULT NOW()")
    private LocalDate dateBooking;

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isBookingPayed() {
        return this.bookingPayed;
    }
    public void setBookingPayed(boolean bookingPayed) {
        this.bookingPayed = bookingPayed;
    }

    public long getBookingId() {
        return bookingId;
    }
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getHeadBookerId() {
        return this.headBookerId;
    }
    public void setHeadBookerId(long headBookerId) {
        this.headBookerId = headBookerId;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmountPayed() {
        return this.amountPayed;
    }
    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public String getBookedRooms() {
        return this.bookedRooms;
    }
    public void setBookedRooms(String bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public LocalDate getDateStart() {
        return this.dateStart;
    }
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return this.dateEnd;
    }
    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public EBookingStatus getBookingStatus() {
        return this.bookingStatus;
    }
    public void setBookingStatus(EBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public EPaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDateBooking() {
        return this.dateBooking;
    }

    public boolean isEmpty() {
        if(this.getBookingId() == 0) {
            return true;
        }
        return false;
    }
}
