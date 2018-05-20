package com.konovalov.order.DAO;

import com.konovalov.order.entity.Clients;

import java.util.List;


public interface CliensDAO {

    //create
    void add(Clients goods);

    //read
    List<Clients> getAll();
    Clients getById(int id);

    //update
    void update(Clients goods);

    //delete
    void remove(Clients goods);
}
