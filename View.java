package ltb;

import java.sql.*;

/**
 *
 * @author Learning Team B
 */
class View extends Databasetest{

    // Print out all the current contents of the database
    
    static void viewDatabase() {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ANIMALS";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("------------------------");
            while(rs.next()){
                System.out.print(rs.getInt("ID") + " ");
                System.out.print(rs.getString("ANIMAL_NAME") + " " );
                System.out.print(rs.getString("COLOR") + " " );
                System.out.print(rs.getString("ANIMAL_CLASS") + " " );
                System.out.println();
            }
            System.out.println();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
    @Override
    public void run(){
        viewDatabase();

    }
     
}
