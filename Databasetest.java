package ltb;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Learning Team B prg421 Roland Morales July 6, 2016
 */
public class Databasetest implements Runnable{

    static Connection conn;
    static int userInput;
    static String user, pswd, url = "jdbc:derby://localhost:1527/LTBWEEK5;create=true;user=ltb;password=prg421";
    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        System.out.println("Welcome to the Animal Database!");
        System.out.println("Please login: ");

        // Get user input to log into the database
        //getLogin();
        
        // Use a try-catch block to see if username and password
        // combination are correct.

        Databasetest data = new Databasetest();
        Thread t2 = new Thread(data);
        t2.start();
        
    }

    //Connect to the AnimalDB database using the url,
    //and the username and password provided by the user.
    private static void createConnection() throws SQLException, InterruptedException {
            
        try {
            conn = DriverManager.getConnection(url, user, pswd);
            if (conn.isValid(0)) {
                System.out.println("Connection successful\n");

            }
            do {
                System.out.println("What would you like to do?");
                System.out.println("1: View Database\n2: Edit Database\n3: Add to Database"
                        + "\n0: Exit");
                userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        View view = new View();
                        Thread t1 = new Thread(view);
                        t1.start();
                        t1.join();
                        break;
                    case 2:
                        Edit.editDatabase();
                        break;
                    case 3:
                        Add.addToDatabase();
                        break;
                }
            } while (userInput != 0);
        } catch (SQLNonTransientConnectionException sqle) {
            System.out.println(sqle.getLocalizedMessage());
        }
    }
    /*
    // Get username and password from the user
    static void getLogin() {
        System.out.print("Username: ");
        user = scanner.nextLine();
        System.out.print("Password: ");
        pswd = scanner.nextLine();
    }
*/

    @Override
    public void run() {

            try {
                createConnection();
            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(Databasetest.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}

