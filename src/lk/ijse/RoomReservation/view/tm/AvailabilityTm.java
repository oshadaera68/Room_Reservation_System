package lk.ijse.RoomReservation.view.tm;


public class AvailabilityTm {
    private String roomNumber;
    private String roomAvailability;

    public AvailabilityTm() {
    }

    public AvailabilityTm(String roomNumber, String roomAvailability) {
        this.roomNumber = roomNumber;
        this.roomAvailability = roomAvailability;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    @Override
    public String toString() {
        return "AvailabilityTM{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomAvailability='" + roomAvailability + '\'' +
                '}';
    }
}
