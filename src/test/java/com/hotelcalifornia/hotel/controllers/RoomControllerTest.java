package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Room;
import com.hotelcalifornia.hotel.services.RoomService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RoomControllerTest {
    @InjectMocks
    private RoomController roomController;
    @Mock
    private RoomService roomService;

    private MockMvc mockMvc;
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
    }
    @Test
    public void addrooms() throws Exception{
//        List<Room> rooms = new ArrayList<>();
//        Room room = new Room();
//        room.setAdults(1);
//        String jsonString =  "[{'floor':'1', 'type': 'Single', 'adults': '1', 'children': '0', 'bedtype': 'Single', 'isDisabled': 'FALSE'}]";
//
////        when(roomService.addRooms(rooms)).thenReturn()
//        this.mockMvc.perform(post("/api/rooms")
//                            .content(jsonString))
//                            .andDo(print())
//                            .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("Single"));
    }

    @Test
    public void getRoomByID() {
    }

    @Test
    public void bookRoom() {
    }

    @Test
    public void getAllRooms() {

    }

    @Test
    public void editRooms() {
    }

    @Test
    public void findRooms() {
    }
}