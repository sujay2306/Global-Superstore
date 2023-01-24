package com.ltp.globalsuperstore;

import jdk.jfr.Category;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class item {
    private String category;
    private String name;
    private Double price;
    private Double discount;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public Date getDate() {
        return date;
    }

    public item(String category, String name, Double discount, Double price, Date date){
        this.name = name;
        this.discount = discount;
        this.category = category;
        this.price = price;

        this.date = date;

    }

    public item(){

    }
}
