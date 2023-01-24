package com.ltp.globalsuperstore;

import com.sun.jdi.event.StepEvent;
import jdk.jfr.Category;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class item {
    private String category;
    private String name;
    private Double price;
    private Double discount;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private String id;
    public String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

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
        this.id = UUID.randomUUID().toString();
    }
}
