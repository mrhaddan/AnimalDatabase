package ltb;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Learning Team B
 */
public class Edit extends Databasetest{
    
    static void editDatabase() throws SQLException, InterruptedException{

        Statement stmt = conn.createStatement();
        String editQuery, newValue, change = null;
        Scanner x = new Scanner(System.in);
        
        // Had to create second scanner to get String input from user.
        // Stupid Scanner
        Scanner y = new Scanner(System.in);
        
        System.out.println("What would you like to edit?");
        // Print database for user to make a selection
        View view = new View();
        Thread t1 = new Thread(view);
        t1.start();
        t1.join();
        int edit = x.nextInt();
        
        System.out.println("Would you like to edit \n"
                + "1:Name\n2:Color\n3:Class");
        int editAnimal = x.nextInt();
        
        switch(editAnimal){
            case 1:
                change = "ANIMAL_NAME";
                break;
            case 2:
                change = "COLOR";
                break;
            case 3:
                change = "ANIMAL_CLASS";
                break;
        }
        System.out.print("Enter the new value: ");
        newValue = y.nextLine();
        
        editQuery = "UPDATE ANIMALS SET " + change + "='" + newValue + "' WHERE ID = " + edit;
        
        int rs = stmt.executeUpdate(editQuery);
        
    }
 
}
