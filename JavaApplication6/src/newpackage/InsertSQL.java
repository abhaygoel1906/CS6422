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
public class InsertSQL {
    public static void main(String[] args) {
        String q = "insert into user values ('ijkl', 1234567099, 'IJ', 'KL');";
        try {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/assign4", "root", "qwert123");
            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
            //rs.close();
            stmt.close();
            con.close();
        } catch(Exception e) {
           System.out.println(e.getMessage());
        }
        
    }
}
