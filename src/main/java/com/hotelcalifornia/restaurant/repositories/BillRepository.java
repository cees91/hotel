package com.hotelcalifornia.restaurant.repositories;

import com.hotelcalifornia.restaurant.models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    void saveBill(Bill bill);
    long findById(long id);
    void deleteById(long id);


}
