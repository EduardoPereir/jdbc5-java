package application;

import java.sql.*;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase" , "root", "eduardop$filho");
            conn.setAutoCommit(false);
            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 1234 WHERE departmentId = 1 ");

//            int x = 1;
//            if (x < 2){
//                throw new SQLException("Fake Error");
//            }

            int rows = st.executeUpdate("UPDATE seller SET BaseSalary = 7890 WHERE departmentId = 2 ");

            conn.commit();
            System.out.println("Rows 1 -> " + rows1);
            System.out.println("Rows 2 -> " + rows);


        }
        catch (SQLException e ){
            try{
                conn.rollback();
            }catch (SQLException e1){
                throw new RuntimeException("Cannot roll back the transaction! Caused by: " + e1.getMessage());
            }
            throw new RuntimeException("Transaction rolled back!");
        }

    }
}