package ru.netology.product.manager;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone(int smartphoneId, String smartphoneName, String smartphoneManufacturer) {
        super.id = smartphoneId;
        super.name = smartphoneName;
        this.manufacturer = smartphoneManufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (this.manufacturer.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}