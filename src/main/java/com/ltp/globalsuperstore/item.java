package com.ltp.globalsuperstore;

import com.sun.jdi.event.StepEvent;
import jdk.jfr.Category;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class item {
    @NotBlank(message = "field cannot be left blank")
    private String category;
    @NotBlank(message = "field cannot be left blank")
    private String name;
    @Min(value = 0, message = "price cannot be negative")
    private Double price;
    @Min(value = 0, message = "discount cannot be negative")
    private Double discount;
    @Past(message = "Date must be of future")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private String id;
    public String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public void setId(String id){  //here it is set to old id during update
        this.id = id;
    }

    public String getId() {
        return this.id;        //when we click on update got a new id
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
