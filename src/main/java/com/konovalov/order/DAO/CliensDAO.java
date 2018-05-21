package com.konovalov.order.DAO;

import com.konovalov.order.entity.Clients;

import java.util.List;


public interface CliensDAO {

    //create
    void add(Clients clients);
    int addIdClient(Clients clients);

    //read
    List<Clients> getAll();
    Clients getById(int id);


    //update
    void update(int idClients);

    //delete
    void remove(Clients clients);
    void remove(int id);
}
