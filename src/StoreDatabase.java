import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreDatabase {

    public StoreDatabase() {
        try {
            final String DB_URL = "jdbc:derby:StoreDB;create=true";

            Connection con = DriverManager.getConnection(DB_URL);

            dropTables(con);

            buildProductTable(con);

            buildShoppingCart(con);

            con.close();

        } catch (Exception e) {
            System.out.println("Error Creating the Table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables(Connection con) {

        try {
            Statement st = con.createStatement();

            try {
                st.execute("DROP TABLE Product");
                System.out.println("Product table dropped.");
            } catch (SQLException ex) {

            }
            try {
                // Drop the Coffee table.
                st.execute("DROP TABLE ShoppingCart");
                System.out.println("ShoppingCart table dropped.");
            } catch (SQLException ex) {

            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void buildProductTable(Connection con) {
        try {
            // Get a Statement object.
            Statement st = con.createStatement();

            // Create the table.
            st.execute("CREATE TABLE Product (" +
                    "ProductID INTEGER NOT NULL PRIMARY KEY, " +
                    "ProductName CHAR(25),"+
                    "Description VARCHAR(250)," +
                    "Price DOUBLE )");

            // Insert row #1.
            st.execute("INSERT INTO Product VALUES ( " +
                    "1, " +
                    "'Hazal Dress', " +
                    "'They are manufactured  from %100 cotton, scrim, special, local fabric." +
                    "They are dyed by antique dyeing method. They do not contain carcinogen substance.',"+
                    "35.00)");

            // Insert row #1.
            st.execute("INSERT INTO Product VALUES ( " +
                    "2, " +
                    "'Beste Dress', " +
                    "'They are manufactured from %100 cotton.They do not contain carcinogen substance.', "+
                    "25.00)");

            System.out.println("Product table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildShoppingCart(Connection con) {
        try {
            // Get a Statement object.
            Statement st = con.createStatement();

            // Create the table.
            st.execute("CREATE TABLE ShoppingCart(" +
                    "ItemID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "ProductName CHAR(25),"+
//                    "Size CHAR(10),"+
                    "Price DOUBLE ");

            System.out.println("ShoppingCart table created.");
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}

