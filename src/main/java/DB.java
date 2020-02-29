import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "d244224d";
    public static Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
