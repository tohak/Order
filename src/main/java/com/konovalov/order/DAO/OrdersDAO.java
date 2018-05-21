package com.konovalov.order.DAO;


import com.konovalov.order.entity.Clients;
import com.konovalov.order.entity.Goods;
import com.konovalov.order.entity.Orders;

import java.util.List;

public interface OrdersDAO {
    //create
    void add(int idClient, int idGoods);


    //read
    List<Orders> getAll();
    Orders getById(int id);

    //update
    void update(Orders orders, int id);

    //delete
    void remove(Orders orders);
    void remove(int id);
}
