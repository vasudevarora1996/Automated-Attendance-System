package com.example.vasudev.attendancesystem;



public class Product {
    private String date;
    private String time;
    private String card_id;
    private String name;

    public Product(String date, String time, String card_id, String name) {

        this.date = date;
        this.time = time;
        this.card_id = card_id;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCard_id() {
        return card_id;
    }

    public String getName() {
        return name;
    }

}
