package com.konovalov.order.entity;


public class Goods {
    private int idgoods;
    private String nameGoods;
    private int weight;
    private int price;

    public Goods() {
    }

    public Goods( String nameGoods, int weight, int price) {
        this.nameGoods = nameGoods;
        this.weight = weight;
        this.price = price;
    }

    public int getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(int idgoods) {
        this.idgoods = idgoods;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (idgoods != goods.idgoods) return false;
        if (weight != goods.weight) return false;
        if (price != goods.price) return false;
        return nameGoods != null ? nameGoods.equals(goods.nameGoods) : goods.nameGoods == null;
    }

    @Override
    public int hashCode() {
        int result = idgoods;
        result = 31 * result + (nameGoods != null ? nameGoods.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "goods{" +
                "idgoods=" + idgoods +
                ", nameGoods='" + nameGoods + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
