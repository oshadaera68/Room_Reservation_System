/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.view.tm;

import javafx.scene.control.Button;

public class RoomTm {
    private String id;
    private String type;
    private String charges;
    private String offers;
    private Button delete;

    public RoomTm() {
    }

    public RoomTm(String id, String type, String charges, String offers, Button delete) {
        this.id = id;
        this.type = type;
        this.charges = charges;
        this.offers = offers;
        this.delete = delete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "RoomTm{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", charges='" + charges + '\'' +
                ", offers='" + offers + '\'' +
                ", delete=" + delete +
                '}';
    }
}
