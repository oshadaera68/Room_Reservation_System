/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.model;

public class Income {
    private String month;
    private String year;

    public Income() {
    }

    public Income(String month, String year) {
        this.month = month;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Income{" +
                "month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}