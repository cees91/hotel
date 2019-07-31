package com.hotelcalifornia.hotel.utils;

import com.hotelcalifornia.hotel.Interfaces.BookingSaver;
import com.hotelcalifornia.hotel.models.Booking;

import java.io.*;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CSVWriter {

    public void removeBooking(int index){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bookings.csv"));
            ArrayList<String> csvLines = new ArrayList<>();
            String line = "";
            int iterator = 0;
            try {
                FileWriter csvWriter = new FileWriter("bookings.csv");
                while ((line = br.readLine()) != null) {
                    line = br.readLine();
                    if (iterator != index) {
                        csvWriter.append(line);
                        iterator++;
                    } else {
                        iterator++;
                    }
                }
                csvWriter.flush();
                csvWriter.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }catch(FileNotFoundException error){
            System.out.println(error);
        }

    }
    public void writeSingleLineToCSV(String bookingLine, String fileName) {
        try {
            FileWriter csvWriter = new FileWriter(fileName);
            csvWriter.append(bookingLine);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException error) {
            System.out.println("Error reading file " + error);
        }
    }

    private String getDateAsString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String newDate = df.format(date);
        return newDate;
    }
}
