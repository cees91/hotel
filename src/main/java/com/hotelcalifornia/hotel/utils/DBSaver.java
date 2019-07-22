package com.hotelcalifornia.hotel.utils;

import com.hotelcalifornia.hotel.Interfaces.BookingSaver;
import com.hotelcalifornia.hotel.models.Booking;

import java.util.ArrayList;

public class DBSaver implements BookingSaver {
    @Override
    public void saveBooking(Booking booking) {
    }
    public void removeBooking(int i){}
    public void saveBookings(ArrayList<Booking> booking){};
}
