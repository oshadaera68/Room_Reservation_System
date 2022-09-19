/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.view.tm;

import javafx.scene.control.Button;

public class MealTm {
    private String no;
    private String type;
    private String name;
    private String time;
    private String price;
    private Button delete;

    public MealTm() {
    }

    public MealTm(String no, String type, String name, String time, String price, Button delete) {
        this.no = no;
        this.type = type;
        this.name = name;
        this.time = time;
        this.price = price;
        this.delete = delete;
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

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "MealTm{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                ", delete=" + delete +
                '}';
    }
}
