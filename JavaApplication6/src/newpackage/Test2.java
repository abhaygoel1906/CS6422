/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
/**
 *
 * @author aabha
 */
import java.util.*;
import java.sql.*;

 class Thr extends Thread {
    Statement stmt;
    String s;
    public Thr(Statement stmt, String s) {
        this.stmt = stmt;
        this.s = s;
    } 
     
     public void run(Statement stmt, int i) {
        try{            
//            String q="SELECT * from TWEET;";
//            stmt.executeQuery(q);
          //for(int i=0; i<srr.length; i++) {            
            stmt.executeQuery(s);              
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        String[] srr = new String[10];
        srr[0] = "SELECT * from TWEET WHERE num_likes > 100 AND text LIKE '%RT%' GROUP BY tid ORDER BY num_likes ASC;";
        srr[1] = "SELECT * from User INNER JOIN GEO_LOCATION ON User.geo_location_id = GEO_LOCATION.id WHERE GEO_LOCATION.location_name LIKE '%US%' AND join_date < '2012-01-01' AND profile_pic_url != NULL AND bio != NULL;";
        srr[2] = "WITH mention_count AS (SELECT Mentions.tid, COUNT(Mentions.tid) AS MentionCount FROM Mentions GROUP BY Mentions.tid) SELECT * FROM Tweet INNER JOIN mention_count ON Tweet.tid = mention_count.tid WHERE mention_count.MentionCount > 2 GROUP BY Tweet.tid, mention_count.tid, mention_count.mentioncount;";
        srr[3] = "SELECT tid from TWEET INNER JOIN User ON TWEET.author_id = User.UID WHERE TWEET.num_likes < 30 AND User.num_followers > 25;";
        srr[4] = "SELECT * FROM Tweet WHERE num_retweets > num_likes;";
        srr[5] = "SELECT username from User WHERE is_verified = True AND num_followers > 10000;";
        srr[6] = "SELECT * FROM Tweet INNER JOIN User ON Tweet.author_id = User.uid INNER JOIN Geo_Location ON User.geo_location_id = Geo_Location.id WHERE GEO_LOCATION.location_name NOT LIKE 'US';";
        srr[7] = "SELECT * FROM Follows INNER JOIN User ON Follows.follower_id=User.uid INNER JOIN User as User2 ON Follows.following_id=User2.uid WHERE User.is_verified = False AND User2.is_verified = True;";
        srr[8] = "SELECT * from TWEET WHERE time_stamp > '2015-12-31' AND time_stamp < '2021-01-01';";
        srr[9] = "SELECT * from User WHERE username LIKE '%a%' OR username LIKE '%A%';";
        try{    
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/cs6422", "root", "qwert123");
            Statement stmt=con.createStatement();
            String q="SELECT * from TWEET;"; 
            stmt.executeQuery(q);
            //run(stmt);
            for(int i=0; i<srr.length; i++) {
                Thr temp = new Thr(stmt, srr[i]);
                long l1 = System.nanoTime();
                temp.start();
                long l2 = System.nanoTime();
                System.out.println(i + ": " + (l2-l1));
            }
        } catch (Exception e) {
            System.out.println("!!!ERROR!!!"+e.getMessage());
        }
    }
}
