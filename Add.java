package ltb;

//import static databasetest.Databasetest.conn;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nickh
 */
public class Add extends Databasetest{

    static void addToDatabase() throws SQLException {
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Add new entry");
        System.out.println("Enter ID: ");
        int ID = sc2.nextInt();
        System.out.print("Enter animal name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter animal color: ");
        String color = sc.nextLine();
        System.out.print("\nEnter animal category: ");
        String category = sc.nextLine();

        String updateQuery = "INSERT INTO ANIMALS(ID, ANIMAL_NAME, COLOR,"
                + " ANIMAL_CLASS) VALUES (" + ID + ",'" + name + "','" + color + "','" + category + "')";
        int updateStatement = stmt.executeUpdate(updateQuery);
    }

}
