package com.konovalov.order.entity;


public class Clients {
    private int idclient;
    private  int money;

    public Clients() {
    }

    public Clients(int idclient, int money) {
        this.idclient = idclient;
        this.money = money;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (idclient != clients.idclient) return false;
        return money == clients.money;
    }

    @Override
    public int hashCode() {
        int result = idclient;
        result = 31 * result + money;
        return result;
    }

    @Override
    public String toString() {
        return "clients{" +
                "idclient=" + idclient +
                ", money=" + money +
                '}';
    }
}
