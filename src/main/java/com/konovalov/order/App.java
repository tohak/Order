package com.konovalov.order;


import com.konovalov.order.service.DBUtil;
import com.konovalov.order.service.UtilService;

public class App {
    public static void main(String[] args) {
        DBUtil util = new DBUtil();
        // create table
        util.createTable();


        //Util
        UtilService utilService = new UtilService();

        //add Six Goods
        utilService.addGoods();

        //add order
        int[] idGoods = {1, 2, 3};
        utilService.addOrder(idGoods);
        
        //get invoice
        utilService.getInvoice(1);
    }
}
