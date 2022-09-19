/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.model;

public class Room {
    private String id;
    private String type;
    private String charges;
    private String offers;

    public Room() {
    }

    public Room(String id, String type, String charges, String offers) {
        this.id = id;
        this.type = type;
        this.charges = charges;
        this.offers = offers;
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

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", charges='" + charges + '\'' +
                ", offers='" + offers + '\'' +
                '}';
    }
}
