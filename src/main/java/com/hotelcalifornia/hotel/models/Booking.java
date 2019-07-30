package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EBookingStatus;
import com.hotelcalifornia.hotel.Enums.EPaymentMethod;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // variables regarding payment
    @NotNull
    @ColumnDefault("FALSE")
    private boolean bookingPayed;

    @NotNull
    @ColumnDefault("0.0")
    private double price;

    @NotNull
    @ColumnDefault("0.0")
    private double amountPayed;

    // the user that booked the room(s)
    @OneToMany
    private User headBooker;
    @NotNull
    private int numberOfGuests;
    // list of rooms that are booked
    @ManyToMany
    private List<Room> bookedRooms;
    // enum variables
    @Enumerated(EnumType.ORDINAL)
    private EBookingStatus bookingStatus;
    @Enumerated(EnumType.ORDINAL)
    private EPaymentMethod paymentMethod;

    // dates
    @NotNull
    private LocalDate dateStart;
    @NotNull
    private LocalDate dateEnd;

    @NotNull
    @ColumnDefault("NOW()")
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public User getHeadBooker() {
        return this.headBooker;
    }
    public void setHeadBooker(User headBooker) {
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

    public List<Room> getBookedRooms() {
        return this.bookedRooms;
    }
    public void setBookedRooms(List<Room> bookedRooms) {
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
        if(this.getId() == 0) {
            return true;
        }
        return false;
    }
}
