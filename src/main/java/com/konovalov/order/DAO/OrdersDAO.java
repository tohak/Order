package com.konovalov.order.DAO;


import com.konovalov.order.entity.Orders;

import java.util.List;

public interface OrdersDAO {
    //create
    void add(Orders goods);

    //read
    List<Orders> getAll();
    Orders getById(int id);

    //update
    void update(Orders goods);

    //delete
    void remove(Orders goods);
}
