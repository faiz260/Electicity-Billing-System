import java.awt.BorderLayout;
    import java.sql.*;
    import javax.swing.*;
import javax.swing.table.DefaultTableModel;
   // import javax.swing.JOptionPane;
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
    public boolean addCustomer(String mno, String name, String address, String email, String phone)
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
    public boolean viewCustomer()
    {
        String out = "S.No\tMeterNumber\tCustomerName\t\tAddress\t\t\tEmail\t\t\t    PhoneNo\t";
        System.out.println(out);
        String sql = "select * from Customer";
        int i = 1;
        try
        {
            state = con.createStatement();
            res = state.executeQuery(sql);
            while(res.next())
            {
                String id = res.getString("MeterNumber");
                String name = res.getString("CustomerName");
                String address = res.getString("Address");
                String email = res.getString("Email");
                String phoneno = res.getString("PhoneNo");
                //String data = i + "\t" + id + "\t" + name + "\t" + address + "\t" + email + "\t" + phoneno + "\n";
                System.out.println(i + "\t" + id + "\t\t" + name + "\t\t" + address + "\t " + email + "\t    " + phoneno);
                i++;
                //JOptionPane.showMessageDialog(null, out+data);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }
     public boolean DeleteCustomer(int id)
    {
        boolean b;
        String sql = "delete from Customer where MeterNumber='"+id+"'";
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









       
        
//        String[] columnNames = {"MeterNumber","CustomerName","Address","Email","PhoneNo"};
//        JFrame frame1 = new JFrame("Customer Records");
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setLayout(new BorderLayout());
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(columnNames);
//        JTable table = new JTable();
//        table.setModel(model);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        table.setFillsViewportHeight(true);
//        JScrollPane scroll = new JScrollPane(table);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        try {
//            prestate = con.prepareStatement("select * from Customer");
//            res = prestate.executeQuery();
//            int i = 0;
//            if (res.next()) {
//                int cmeterno = res.getInt("MeterNumber");
//                String cname = res.getString("CustomerName");
//                String caddress = res.getString("Address");
//
//                String cemail = res.getString("Email");
//
//                String cphoneno = res.getString("PhoneNo");
//
//                model.addRow(new Object[]{cmeterno, cname, caddress, cemail, cphoneno});
//
//                i++;
//
//            }
//
//            if (i < 1) {
//
//                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
//
//            }
//
//            else {
//
//                System.out.println(i + " Record Found");
//
//            } 
//        }
//        catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(null, ex);
//            b = false;
//        }
//        frame1.add(scroll);
//
//        frame1.setVisible(true);
//
//        frame1.setResizable(true);
        
        //from = (String) c1.getSelectedItem();
        /* frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

//String textvalue = textbox.getText();

        String uname = "";

        String email = "";

        String pass = "";

        String cou = "";

 

        try {

            pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {

                uname = rs.getString("uname");

                email = rs.getString("umail");

                pass = rs.getString("upass");

                cou = rs.getString("ucountry");

                model.addRow(new Object[]{uname, email, pass, cou});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);*/
        
        
        
        
        
        
        /*String sql = "SELECT id, first, last, age FROM Registration";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         String first = rs.getString("first");
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Age: " + age);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }*/