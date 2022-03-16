package ru.netology.domain;

public class Smartphone extends Product {
    private String name;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String name1, String manufacturer) {
        super(id, name, price);
        this.name = name1;
        this.manufacturer = manufacturer;
    }

    @Override
    public String getName() {
        return name;
    }
}
