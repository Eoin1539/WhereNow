package nci.wherenow;

public class Restaurant {


    private int id;
    private String title;
    private  String address;
    private  String distance;
    private  String duration;
    private  int image;


    public Restaurant(int id, String title, String address, String distance, String duration, int image) {
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

    public  String getTitle() {
        return title;
    }

    public  String getAddress() {
        return address;
    }

    public  String getDistance() {
        return distance;
    }

    public  String getDuration() {
        return duration;
    }

    public  int getImage() {
        return image;
    }
}