package com.hotelcalifornia.restaurant.repositories;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class TableRepository implements CrudRepository {

    private static TableRepository instance = null;
    private TableRepository(){
        //defeate instantiation
    }

    public static TableRepository getInstance() {
        if(instance == null) {
            instance = new TableRepository();
        }
        return instance;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable iterable) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void deleteAll(Iterable iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
