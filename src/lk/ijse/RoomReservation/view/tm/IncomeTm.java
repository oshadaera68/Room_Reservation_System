/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.view.tm;

public class IncomeTm {
    private int month;
    private double income;

    public IncomeTm() {
    }

    public IncomeTm(int month, double income) {
        this.month = month;
        this.income = income;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "IncomeTm{" +
                "month=" + month +
                ", income=" + income +
                '}';
    }
}
