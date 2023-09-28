package com.example.lab2_gridview_spinner;

public class Dish {
private final String name;
    private final Thumbnail thumbnail;
    private final Boolean isPromotion;

    public Dish(String name, Thumbnail thumbnail, Boolean isPromotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.isPromotion = isPromotion;
    }

    public String getName() {
        return name;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Boolean getPromotion() {
        return isPromotion;
    }
}
