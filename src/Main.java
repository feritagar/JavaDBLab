import java.sql.*;

public class Main {
    public static void main(String[] args){

        StoreDatabase sd = new StoreDatabase();
        outputDB();
        addContent();
        System.out.println("=====================");
        outputDB();

    }

    public static void addContent () {
        final String DB_URL = "jdbc:derby:StoreDB";
        Statement st = null;
        Connection con = null;
        try {
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            st = con.createStatement();
            System.out.println("Inserting records into the table...");
            st = con.createStatement();

            String sql = "INSERT INTO Product " +
                    "VALUES (3,'Hazal Dress','They are manufactured  from %100 cotton, scrim, special, local fabric." +
                    "They are dyed by antique dyeing method. They do not contain carcinogen substance',35.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (4,'Kanavice Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',30.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (5,'Pecvork Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',40.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (6,'Manyana Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',20.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (7,'Polen Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',50.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (8,'Monalisa Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',25.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (9,'Frilly Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',45.00)";
            st.executeUpdate(sql);
            sql = "INSERT INTO Product " +
                    "VALUES (10,'Yalena Dress','They are manufactured from %100 cotton." +
                    "They do not contain carcinogen substance.',45.00)";

            st.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            //Clean-up environment
            st.close();
            con.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
    public static void outputDB() {
        final String DB_URL = "jdbc:derby:StoreDB";
        Statement st = null;
        Connection con = null;
        try{
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            st = con.createStatement();
            String sql;
            sql = "SELECT ProductID, ProductName, Description, Price FROM Product";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProductID");
                String name = rs.getString("ProductName");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");


                //Display values
                System.out.println("ID: " + id.trim());
                System.out.println("Product Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);
                System.out.println("======================================");



            }
            //STEP 6: Clean-up environment   bu siralamada olmali.
            rs.close();
            st.close();
            con.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }


}
