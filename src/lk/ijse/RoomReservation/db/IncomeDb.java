/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.db;

import lk.ijse.RoomReservation.view.tm.IncomeTm;

import java.util.ArrayList;

public class IncomeDb {
    public static ArrayList<IncomeTm> monthIncome = new ArrayList();
    static {
        monthIncome.add(new IncomeTm(1, 0));
    }
}
