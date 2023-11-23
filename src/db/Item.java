package db;

public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String photoURL;

    public Item(Long id, String name, String description, double price, String photoURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photoURL = photoURL;
    }

    public Item(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
