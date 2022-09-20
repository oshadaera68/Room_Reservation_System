/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

package lk.ijse.RoomReservation.db;

import lk.ijse.RoomReservation.model.Customer;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Customer> customerTable = new ArrayList();

    static {
        customerTable.add(
                new Customer("R001","Hasika","70528899V","0715588965","hasi@gmail.com","Panadura","Yes")
        );
        customerTable.add(
                new Customer("R002","Maneesha","70745899V","0452688965","mani@gmail.com","Galle","Yes")
        );
    }
}
