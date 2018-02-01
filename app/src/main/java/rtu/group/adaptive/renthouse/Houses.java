package rtu.group.adaptive.renthouse;

/**
 * Created by Doston on 2/1/2018.
 */

public class Houses {

    private String ID, city;
    private int num_rooms, min_price, max_price, floor;

    public Houses(String ID, String city, int num_rooms, int min_price, int max_price, int floor) {
        this.ID = ID;
        this.city = city;
        this.num_rooms = num_rooms;
        this.min_price = min_price;
        this.max_price = max_price;
        this.floor = floor;
    }

    public String getID() {
        return ID;
    }

    public String getCity() {
        return city;
    }

    public int getNum_rooms() {
        return num_rooms;
    }

    public int getMin_price() {
        return min_price;
    }

    public int getMax_price() {
        return max_price;
    }

    public int getFloor() {
        return floor;
    }
}
