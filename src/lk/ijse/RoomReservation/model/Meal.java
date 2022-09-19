/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.model;

public class Meal {
    private String no;
    private String type;
    private String name;
    private String time;
    private String price;

    public Meal() {
    }

    public Meal(String no, String type, String name, String time, String price) {
        this.no = no;
        this.type = type;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MealPackages{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}