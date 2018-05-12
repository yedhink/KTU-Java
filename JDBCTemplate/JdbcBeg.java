
import java.sql.*;
/********************
  Contributed by leo
  ->make sure that you have JDBC Driver install.
  ->You should have a SQL server Running.
************************/
public class JdbcBeg implements Runnable{
    //Threads are just used to make Server timings
    public void run() {
        System.out.print("Connecting to SQL DB waiting For Connection ");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                System.out.println("Error while threading .");
            }
        }
            System.out.println("\nYou are connected to SQL DB");

    }
    public static void main(String[] args) {
        Thread thread=new Thread(new JdbcBeg());
        thread.start();
        try{
            Thread.sleep(5000);
            thread.join();
        }catch (InterruptedException e){
            System.out.println("Something wrong while threading.");
        }

        try {
            //Connection is obtained using GET method. Replace the url,username,password with yours.
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "nopass1234");
            Statement statement = connection.createStatement();
            statement.executeUpdate("use employee");//Use your update statements instead of mine.
            ResultSet resultSet = statement.executeQuery("select * from livesin");//Use your select queries here
            //Result is stored as a ResultSet object
            while (resultSet.next()) {
                System.out.println();
                System.out.println(resultSet.getString("pname") + "  " + resultSet.getString("street") + "  " + resultSet.getString("city") + " ");
                //Replace the column label to columns used in the table
            }

        } catch (SQLException sqlException) {
            System.out.println("Error occurred while processing");
        }
        }
    }