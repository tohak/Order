package com.konovalov.order.DAO;


import com.konovalov.order.entity.Goods;

import java.util.List;


public interface GoodsDAO {

    //create
    void add(Goods goods);

    //read
    List<Goods> getAll();
    Goods getById(int id);

    //update
    void update(Goods good, int id);

    //delete
    void remove(Goods goods);
    void remove (int id);

}
