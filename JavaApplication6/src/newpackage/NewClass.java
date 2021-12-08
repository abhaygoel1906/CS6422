/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.util.*;
import java.sql.*;
/**
 *
 * @author aabha
 */
public class NewClass {       
    public static void main(String[] args) {
        try {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/assign4", "root", "qwert123");
            Statement stmt=con.createStatement();
            String sql="select * from user;";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {
                //String b=rs.getString(1); System.out.print(b+ " | ");
                System.out.print(rs.getString(1)+" | ");
                System.out.print(rs.getString(2)+" | ");
                System.out.print(rs.getString(3)+" | ");
                System.out.print(rs.getString(4)+" | ");
                System.out.println("");
            }
            
//            rs.close();
//            stmt.close();
//            con.close();
        } catch(Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
