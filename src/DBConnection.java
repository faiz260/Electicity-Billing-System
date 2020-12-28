import java.sql.*;
    import javax.swing.JOptionPane;
public class DBConnection {
    Connection con = null;
    public Connection EstablishConnection()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://D:\\Project.accdb");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);

        }
        return con;
    }
}