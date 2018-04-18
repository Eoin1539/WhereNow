package nci.wherenow;
import java.util.Date;

/**
 * Created by KarlMcSherry on 18/04/2018.
 */

public class message {
    public String user;
    public String text;
    public String id;
    public long time;

    public message(String text,String user, String id ){
        this.user = user;
        this.text = text;
        this.id = id;
        time = new Date().getTime();
    }

    public message(){

    }

    public void setUser(String user){
        this.user = user;
    }

    public String getUser(){
        return user;
    }

    public void setText(){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setId(){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setTime(long time){
        this.time = time;
    }

    public long getTime(){
        return time;
    }


}
