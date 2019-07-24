package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EBookingStatus;
import com.hotelcalifornia.hotel.Enums.EPaymentMethod;

import java.util.Date;

import static java.lang.Long.MAX_VALUE;

public class Booking {

    private long bookingId = -1;

    // variables regarding payment
    private boolean bookingPayed;
    private double price = -1;
    private double amountPayed;

    // the user that booked the room(s)
    private Guest headBooker;
    private int numberOfGuests;
    // list of rooms that are booked
    private Room[] bookedRooms;
    // enum variables
    private EBookingStatus bookingStatus;
    private EPaymentMethod paymentMethod;
    // dates
    private Date startDate;
    private Date endDate;
    private Date bookingDate;
    // basic constructor without arguments
    public Booking() {
        this.bookingId = generateId();
        this.bookingDate = new Date(); // creating a Date without specifying a date gives it the date of today
    }

    /**
     * do 1+ so the ID is never 0
     * Math.random() returns a random value between 0 and 0.999...
     * multiply by the max of a long
     * -1 to not roll over the long value(because we did +1 in the beginning)
     * @return the new id as a long
     */
    private long generateId() {
        return 1+(long)(Math.random() * MAX_VALUE-1);
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    // full constructor

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

    public Guest getHeadBooker() {
        return this.headBooker;
    }
    public void setHeadBooker(Guest headBooker) {
        this.headBooker = headBooker;
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

    public Room[] getBookedRooms() {
        return this.bookedRooms;
    }
    public void setBookedRooms(Room[] bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public Date getStartDate() {
        return this.startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public boolean isEmpty() {
        if(this.getBookingId() == 0) {
            return true;
        }
        return false;
    }
}
