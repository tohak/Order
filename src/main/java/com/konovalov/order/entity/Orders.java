package com.konovalov.order.entity;


public class Orders {
    private int idorders;
    private int idclient;
    private int idegoods;

    public Orders() {
    }

    public Orders(int idorders, int idclient, int idegoods) {
        this.idorders = idorders;
        this.idclient = idclient;
        this.idegoods = idegoods;
    }

    public int getIdorders() {
        return idorders;
    }

    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdegoods() {
        return idegoods;
    }

    public void setIdegoods(int idegoods) {
        this.idegoods = idegoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (idorders != orders.idorders) return false;
        if (idclient != orders.idclient) return false;
        return idegoods == orders.idegoods;
    }

    @Override
    public int hashCode() {
        int result = idorders;
        result = 31 * result + idclient;
        result = 31 * result + idegoods;
        return result;
    }

    @Override
    public String toString() {
        return "orders{" +
                "idorders=" + idorders +
                ", idclient=" + idclient +
                ", idegoods=" + idegoods +
                '}';
    }
}
