package Db_Automation;

import Db_Base.Base_Class;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud_Operation extends Base_Class
{
    @Test
    public void CreateTableTest() throws SQLException {
        con = this.setUp();
        Statement stmt = con.createStatement();
        String Query = "CREATE TABLE Customers (\n" +
                "     CustomerID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "     Name VARCHAR(50) NOT NULL\n" +
                "     );";
        stmt.execute(Query);
        System.out.println("Table Created Successfully");
        con.close();
    }

    @Test
    public void Db_Test_InsertData() throws SQLException {
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("insert into Customers values(?,?)");
        ps.setString(1, "101");
        ps.setString(2, "Vijaya");

        ps.setString(1, "102");
        ps.setString(2, "Samantha");
        ps.executeUpdate();

    }

    @Test
    public void Db_Test_UpdateData() throws SQLException {
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("Update Customers set Name = 'sheetal' where CustomerID  =101");
        ps.executeUpdate();
    }

    @Test
    public void Db_Test_DeleteData() throws SQLException {
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("delete from customers  where CustomerId = 102 ");
        ps.executeUpdate();

    }
}

