package com.konovalov.order.service;

import com.konovalov.order.DAO.OrdersDAO;
import com.konovalov.order.entity.Clients;
import com.konovalov.order.entity.Goods;
import com.konovalov.order.entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersService extends DBUtil implements OrdersDAO {

    Connection connection = getConnection();

    @Override
    public void add(int idClient, int idGoods) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO orders(idclient,idgoods) VALUES (?,?)")) {
            ps.setInt(1, idClient);
            ps.setInt(2, idGoods);
            ps.executeUpdate();
            System.out.println("add orders Ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("add orders no");
        }
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> ordersList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT  * FROM orders");
            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setIdorders(resultSet.getInt("idorders"));
                orders.setIdclient(resultSet.getInt("idclient"));
                orders.setIdegoods(resultSet.getInt("idgoods"));
                ordersList.add(orders);
                System.out.println("getAll Orders OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("getAll Orders NO");
        }
        return ordersList;
    }

    @Override
    public Orders getById(int id) {
        Orders orders = new Orders();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders WHERE idorders=?")) {
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.setIdorders(resultSet.getInt("idorders"));
                orders.setIdclient(resultSet.getInt("idclient"));
                orders.setIdegoods(resultSet.getInt("idgoods"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(Orders orders, int id) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE  orders SET idclient=?,idgoods=? WHERE idorders=?")) {
            ps.setInt(1, orders.getIdclient());
            ps.setInt(2, orders.getIdegoods());
            ps.setInt(3, orders.getIdorders());
            ps.executeUpdate();
            System.out.println("Update orders OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update orders NO");
        }
    }

    @Override
    public void remove(Orders orders) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE  FROM orders WHERE idorders=?")) {
            ps.setInt(1, orders.getIdorders());
            ps.executeUpdate();
            System.out.println("Delete Orders OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete Orders NO");
        }
    }

    @Override
    public void remove(int id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE  FROM orders WHERE idorders=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Delete Orders OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Delete Orders NO");
        }
    }
}
