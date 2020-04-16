package model;

public class CategoryShoes {
    private int id;
    private String trademark;
    private String status;

    public CategoryShoes() {
    }

    public CategoryShoes(String trademark, String status){
        this.trademark = trademark;
        this.status = status;

    }
    public CategoryShoes(int id, String trademark, String status) {
        this.id = id;
        this.trademark = trademark;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
