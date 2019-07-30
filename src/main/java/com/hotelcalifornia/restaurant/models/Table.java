package com.hotelcalifornia.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Table {

    @Id
    private int tableId;
    private int capacity;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
