package com.konovalov.order.service;

import com.konovalov.order.DAO.CliensDAO;
import com.konovalov.order.entity.Clients;
import com.konovalov.order.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsService extends DBUtil implements CliensDAO {

    Connection connection = getConnection();

    @Override
    public void add(Clients clients) {
        try (PreparedStatement pr = connection.prepareStatement("INSERT INTO clients (money) VALUES (?)")) {
            pr.setInt(1, 0);
            pr.executeUpdate();
            System.out.println("Add Client - Ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("add Client ERROR");
        }
    }

    @Override
    public int addIdClient(Clients clients) {
        int id=idNext();
            try (PreparedStatement pr = connection.prepareStatement("INSERT INTO clients (money) VALUES (?)")) {
                pr.setInt(1, 0);
                pr.executeUpdate();

                System.out.println("Add Client - Ok idClient="+id);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("add Client ERROR");
            }
        return id;
    }
    private int idNext(){
        int idNext=1;
        try(Statement st=connection.createStatement()){
            ResultSet resultSet=st.executeQuery("SELECT * FROM clients WHERE idclients=" +
                    "(SELECT MAX(idclients) FROM clients)");
            while (resultSet.next()){
                idNext=(resultSet.getInt("idclients"))+1;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idNext;
    }

    @Override
    public List<Clients> getAll() {
        List<Clients> clientsList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM clients");

            while (resultSet.next()) {
                Clients clients = new Clients();
                clients.setIdclient(resultSet.getInt("idclients"));
                clients.setMoney(resultSet.getInt("money"));

                clientsList.add(clients);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }

    @Override
    public Clients getById(int id) {
        Clients clients = new Clients();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE idclients=?")) {
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                clients.setIdclient(resultSet.getInt("idclients"));
                clients.setMoney(resultSet.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void update(int idClients) {
        try (PreparedStatement pr = connection.prepareStatement("UPDATE clients SET money=?")) {
            pr.setInt(1, getSumClient(idClients));
            pr.executeUpdate();
            System.out.println("Update goods - Ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update goods ERROR");
        }
    }
    public int getSumClient(int idClients) {
        int sum = 0;
        String sql = "SELECT price FROM goods WHERE idgoods=" +
                "(SELECT idgoods FROM orders WHERE idclient=(SELECT idclients FROM clients WHERE idclients=?))";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idClients);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                sum += (resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public void remove(Clients clients) {
        try (PreparedStatement pr = connection.prepareStatement("DELETE FROM clients WHERE idclients=?")) {
            pr.setInt(1, clients.getIdclient());
            pr.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    @Override
    public void remove(int id) {
        try (PreparedStatement pr = connection.prepareStatement("DELETE FROM clients WHERE idclients=?")) {
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}

