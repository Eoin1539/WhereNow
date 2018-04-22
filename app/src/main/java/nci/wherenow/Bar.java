package nci.wherenow;


public class Bar {
    private int id;
    private String title;
    private  String address;
    private String barStyle;
    private String PriceRange;
    private  String duration;
    private  String image;
    private String Latitude;
    private String Longitude;


    public Bar(){

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

    public String getBarStyle() {
        return barStyle;
    }

    public void setBarStyle(String barStyle) {
        this.barStyle = barStyle;
    }

    public String getPriceRange() {
        return PriceRange;
    }

    public void setPriceRange(String priceRange) {
        PriceRange = priceRange;
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

    public String getlatitude() {
        return Latitude;
    }

    public void setlatitude(String latitude) {
        Latitude = latitude;
    }

    public String getlongitude() {
        return Longitude;
    }

    public void setlongitude(String longitude) {
        Longitude = longitude;
    }
}
