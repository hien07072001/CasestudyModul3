package model;

public class Shoes {
    private int shoes_id;
    private String image_link;
    private String name_shoes;
    private float price;
    private String trademark;
    private String status;

    public Shoes() {
    }

    public Shoes(String image_link, String name_shoes, float price) {
        this.image_link = image_link;
        this.name_shoes = name_shoes;
        this.price = price;
    }

    public Shoes(int shoes_id, String image_link, String name_shoes, float price) {
        this.shoes_id =shoes_id;
        this.image_link=image_link;
        this.name_shoes = name_shoes;
        this.price = price;

    }
    public Shoes( String image_link, String name_shoes, float price, String trademark, String status){
        this.image_link=image_link;
        this.name_shoes= name_shoes;
        this.price = price;
        this.trademark = trademark;
        this.status = status;
    }
    public Shoes(int shoes_id, String image_link, String name_shoes, float price, String trademark, String status){
        this.shoes_id = shoes_id;
        this.image_link=image_link;
        this.name_shoes= name_shoes;
        this.price = price;
        this.trademark = trademark;
        this.status = status;
    }


    public int getShoes_id() {
        return shoes_id;
    }

    public void setShoes_id(int shoes_id) {
        this.shoes_id= shoes_id;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getName_shoes() {
        return name_shoes;
    }

    public void setName_shoes(String name_shoes) {
        this.name_shoes = name_shoes;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
