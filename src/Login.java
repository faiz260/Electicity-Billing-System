    import java.sql.*;
    import javax.swing.JOptionPane;
public class Login extends LoginFrame {
    DBConnection dbc = new DBConnection();
    Connection con = dbc.EstablishConnection();
    Statement state = null;
    PreparedStatement prestate = null;
    ResultSet res = null;
    boolean b;
    public boolean AdminLogin(String name, String password)
    {
        String sql = "select * from Admin where AdminName='"+name+"' and AdminPassword='"+password+"'";
        try
        {
            prestate = con.prepareStatement(sql);
            res = prestate.executeQuery();
            if(res.next())
            {
                b = true;
            }
            else
            {
                b = false;
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }
    public boolean addCustomer(int mno, String name, String address, String email, int phone)
    {
        String sql = "insert into Customer(MeterNumber, CustomerName, Address, Email, PhoneNo) values ('"+mno+"','"+name+"','"+address+"','"+email+"','"+phone+"')";
        try
        {
          state = con.createStatement();
          int res = state.executeUpdate(sql);
          if(res>0)
          {
              b = true;
          }
          else
          {
              b = false;
          }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }
}
