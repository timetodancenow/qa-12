package ru.netology.product.manager;

import lombok.Data;

@Data
public class Product {

    protected int id;
    protected String name;

    //подходит ли продукт поисковому запросу исходя из названия
    public boolean matches(String search) {
        return this.getName().contains(search);
        /*
        if (this.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
         */

        // или в одну строку:
        //return product.getName().contains(search);
    }
}