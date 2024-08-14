package Db_Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base_Class {
    public Connection con;

    @BeforeMethod
    public Connection setUp() throws SQLException {
        try {
            String dburl = "jdbc:mysql://localhost:3306/CRUD";
            String UserName = "root";
            String Password = "pass123";
            con = DriverManager.getConnection(dburl, UserName, Password);
            //return con;
        }
        catch (SQLException sqe)
        {
            System.out.println(sqe.getErrorCode());
            System.out.println(sqe.getSQLState());
            System.out.println(sqe.getMessage());
            sqe.printStackTrace();
        }
        return con;
    }
  @AfterMethod
    public void teardown() throws SQLException{
        con.close();
  }
}
