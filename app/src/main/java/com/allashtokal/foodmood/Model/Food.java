package com.allashtokal.foodmood.Model;

public class Food {

    private String Name,Image,Description,Price,MenuID;

    public Food() {
    }

    public Food(String name, String image, String description, String price, String menuID) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        MenuID = menuID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }
}
