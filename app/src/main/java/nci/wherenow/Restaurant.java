package nci.wherenow;

public class Restaurant {


    private int id;
    private String title;
    private  String address;
    private  String distance;
    private  String duration;
    private  String image;

    public Restaurant(int id, String title, String address, String distance, String duration, String image) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.distance = distance;
        this.duration = duration;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}