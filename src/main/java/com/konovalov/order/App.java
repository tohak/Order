package com.konovalov.order;


import com.konovalov.order.entity.Goods;
import com.konovalov.order.service.DBUtil;
import com.konovalov.order.service.GoodsService;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //     DBUtil util=new DBUtil();
        //create table
        // util.createTable();
        Goods goodsOne = new Goods("BoRW", 150, 180);
        GoodsService goodsService = new GoodsService();


        //System.out.println(goodsService.getById(3));
       // goodsService.update(goodsOne, 2);
goodsService.remove(4);

        List<Goods> list = goodsService.getAll();
        for (Goods goods : list) {
            System.out.println(goods);
        }

    }
}
