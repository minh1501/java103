package model;

import java.util.Date;

public class Item {

    private String name;
    private String image;
    private double price;
    private double discount;
    private Date date;

    public Item() {
    }

    public Item(String name,
                String image,
                double price,
                double discount,
                Date date) {

        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public double getNewPrice() {
        return price * (1 - discount);
    }

    public String getLevel() {

        double p = getNewPrice();

        if(p < 10) {
            return "Giá thấp";
        }

        if(p > 100) {
            return "Giá cao";
        }

        return "Bình thường";
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}