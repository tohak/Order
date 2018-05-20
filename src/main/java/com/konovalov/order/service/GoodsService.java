package com.konovalov.order.service;


import com.konovalov.order.DAO.GoodsDAO;
import com.konovalov.order.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsService extends DBUtil implements GoodsDAO {

    Connection connection = getConnection();


    @Override
    public void add(Goods goods) {
        try (PreparedStatement pr = connection.prepareStatement("INSERT INTO goods(name_goods, weight, price) VALUES (?,?,?)")) {
            pr.setString(1, goods.getNameGoods());
            pr.setInt(2, goods.getWeight());
            pr.setInt(3, goods.getPrice());
            pr.executeUpdate();
            System.out.println("Add goods - Ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("add goods ERROR");
        }
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> goodsList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM goods");

            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setIdgoods(resultSet.getInt("idgoods"));
                goods.setNameGoods(resultSet.getString("name_goods"));
                goods.setWeight(resultSet.getInt("weight"));
                goods.setPrice(resultSet.getInt("price"));
                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public Goods getById(int id) {
        Goods goods = new Goods();
        try (PreparedStatement pr = connection.prepareStatement("SELECT * FROM goods WHERE idgoods=?")) {
            pr.setInt(1, id);

            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                goods.setIdgoods(resultSet.getInt("idgoods"));
                goods.setNameGoods(resultSet.getString("name_goods"));
                goods.setWeight(resultSet.getInt("weight"));
                goods.setPrice(resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;

    }

    @Override
    public void update(Goods goods, int id) {
        try (PreparedStatement pr = connection.prepareStatement("UPDATE goods SET name_goods=?,weight=?,price=? WHERE idgoods=?")) {
            pr.setString(1, goods.getNameGoods());
            pr.setInt(2, goods.getWeight());
            pr.setInt(3, goods.getPrice());
            pr.setInt(4, id);
            pr.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void remove(Goods goods) {
        try (PreparedStatement pr = connection.prepareStatement("DELETE FROM goods WHERE idgoods=?")) {
            pr.setInt(1, goods.getIdgoods());
            pr.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    @Override
    public void remove(int id) {
        try (PreparedStatement pr = connection.prepareStatement("DELETE FROM goods WHERE idgoods=?")) {
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
