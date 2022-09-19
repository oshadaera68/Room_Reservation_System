/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.view.tm;

import javafx.scene.control.Button;

public class RoomMaintenanceTm {
    private String id;
    private String availability;
    private Button available;

    public RoomMaintenanceTm() {
    }

    public RoomMaintenanceTm(String id, String availability, Button available) {
        this.id = id;
        this.availability = availability;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Button getAvailable() {
        return available;
    }

    public void setAvailable(Button available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "RoomMaintanceTm{" +
                "id='" + id + '\'' +
                ", availability='" + availability + '\'' +
                ", available=" + available +
                '}';
    }
}
