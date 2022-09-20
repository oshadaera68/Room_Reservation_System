/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.model;

public class Availability {
    private String id;
    private String txtAvailable;
    private String txtNotAvailable;

    public Availability() {
    }

    public Availability(String id, String txtAvailable, String txtNotAvailable) {
        this.id = id;
        this.txtAvailable = txtAvailable;
        this.txtNotAvailable = txtNotAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxtAvailable() {
        return txtAvailable;
    }

    public void setTxtAvailable(String txtAvailable) {
        this.txtAvailable = txtAvailable;
    }

    public String getTxtNotAvailable() {
        return txtNotAvailable;
    }

    public void setTxtNotAvailable(String txtNotAvailable) {
        this.txtNotAvailable = txtNotAvailable;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id='" + id + '\'' +
                ", txtAvailable='" + txtAvailable + '\'' +
                ", txtNotAvailable='" + txtNotAvailable + '\'' +
                '}';
    }
}