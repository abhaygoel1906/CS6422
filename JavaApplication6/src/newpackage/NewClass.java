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
    public static int getBuckets(int numOfpebbles, List<Integer> bucketSizes){
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        for(int i = 0; i <= numOfpebbles; i++){
            dp.add(Integer.MAX_VALUE-1);
        }
        Collections.sort(bucketSizes, Collections.reverseOrder()); 
       
        for(int i = 0; i < bucketSizes.size(); i++){
            if(bucketSizes.get(i) <= numOfpebbles)
            {
                dp.set(bucketSizes.get(i), 1);                
            }
        }
        for(int i = 1; i <= numOfpebbles; i++){
            for(int j = 0; j < bucketSizes.size(); j++){
                if(i-bucketSizes.get(j) >= 0 && dp.get(i-bucketSizes.get(j)) != Integer.MAX_VALUE){
                    dp.set(i, Math.min(dp.get(i), (Integer)dp.get(i-bucketSizes.get(j)) + 1));
                }
            }
        }
        if(dp.get(numOfpebbles) == Integer.MAX_VALUE-1){
            return -1;
        }
        return dp.get(numOfpebbles);
    }
    
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
            
            rs.close();
            stmt.close();
            con.close();
        } catch(Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
