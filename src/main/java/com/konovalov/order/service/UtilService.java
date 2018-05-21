package com.konovalov.order.service;

import com.konovalov.order.entity.Clients;
import com.konovalov.order.entity.Goods;

import java.util.List;

public class UtilService {
    public void addGoods() {
        GoodsService goodsService = new GoodsService();
        Goods goodsOne = new Goods("Bread", 50, 8);
        Goods goodsTho = new Goods("BreadBlack", 50, 5);
        Goods goodsThree = new Goods("Borscht", 250, 20);
        Goods goodsFour = new Goods("Potato", 150, 15);
        Goods goodsFive = new Goods("Chop", 80, 10);
        Goods goodsSix = new Goods("Salad", 50, 8);

        goodsService.add(goodsOne);
        goodsService.add(goodsTho);
        goodsService.add(goodsThree);
        goodsService.add(goodsFour);
        goodsService.add(goodsFive);
        goodsService.add(goodsSix);
    }

    public void addOrder(int [] idGoods) {
        ClientsService clientsService = new ClientsService();
        OrdersService ordersService = new OrdersService();
        int idClient = clientsService.addIdClient(new Clients());
        for (int i = 0; i <idGoods.length ; i++) {
            ordersService.add(idClient, idGoods[i]);
        }
        clientsService.update(idClient);
    }
    public void getInvoice(int id){
        ClientsService clientsService=new ClientsService();
        System.out.println(clientsService.getById(id));


    }
}
