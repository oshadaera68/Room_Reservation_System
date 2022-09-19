/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.model;

public class RoomMaintenance {
    private String id;
    private String availability;

    public RoomMaintenance() {
    }

    public RoomMaintenance(String id, String availability) {
        this.id = id;
        this.availability = availability;
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

    @Override
    public String toString() {
        return "RoomMaintenance{" +
                "id='" + id + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}