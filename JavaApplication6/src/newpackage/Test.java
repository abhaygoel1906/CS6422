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
public class Test {
    public static void main(String[] args) {
        //Class.forName("java.sql.Driver");
        try{           
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/cs6422", "root", "qwert123");
            Statement stmt=con.createStatement();
            String q="SELECT * from TWEET;"; 
            stmt.executeQuery(q);
            
            q="SELECT * from TWEET WHERE num_likes > 100 AND text LIKE '%RT%' GROUP BY tid ORDER BY num_likes ASC;";
            long l11 = System.nanoTime();
            stmt.executeQuery(q);
            long l12 = System.nanoTime();
            System.out.println("Query 1: " + (l12-l11)/1000000);
            
            q = "SELECT * from User INNER JOIN GEO_LOCATION ON User.geo_location_id = GEO_LOCATION.id WHERE GEO_LOCATION.location_name LIKE '%US%' AND join_date < '2012-01-01' AND profile_pic_url != NULL AND bio != NULL;";
            long l21 = System.nanoTime();
            stmt.executeQuery(q);
            long l22 = System.nanoTime();
            System.out.println("Query 2: " + (l22-l21)/1000000);
            
            q = "WITH mention_count AS (SELECT Mentions.tid, COUNT(Mentions.tid) AS MentionCount FROM Mentions GROUP BY Mentions.tid) SELECT * FROM Tweet INNER JOIN mention_count ON Tweet.tid = mention_count.tid WHERE mention_count.MentionCount > 2 GROUP BY Tweet.tid, mention_count.tid, mention_count.mentioncount;";
            long l31 = System.nanoTime();
            stmt.executeQuery(q);
            long l32 = System.nanoTime();
            System.out.println("Query 3: " + (l32-l31)/1000000);
            
            q = "SELECT tid from TWEET INNER JOIN User ON TWEET.author_id = User.UID WHERE TWEET.num_likes < 30 AND User.num_followers > 25;";
            long l41 = System.nanoTime();
            stmt.executeQuery(q);
            long l42 = System.nanoTime();
            System.out.println("Query 4: " + (l42-l41)/1000000);
            
            q = "SELECT * FROM Tweet WHERE num_retweets > num_likes;";
            long l51 = System.nanoTime();
            stmt.executeQuery(q);
            long l52 = System.nanoTime();
            System.out.println("Query 5: " + (l52-l51)/1000000);
            
            q = "SELECT username from User WHERE is_verified = True AND num_followers > 10000;";
            long l61 = System.nanoTime();
            stmt.executeQuery(q);
            long l62 = System.nanoTime();
            System.out.println("Query 6: " + (l62-l61)/1000000);
            
            q = "SELECT * FROM Tweet INNER JOIN User ON Tweet.author_id = User.uid INNER JOIN Geo_Location ON User.geo_location_id = Geo_Location.id WHERE GEO_LOCATION.location_name NOT LIKE 'US';";
            long l71 = System.nanoTime();
            stmt.executeQuery(q);
            long l72 = System.nanoTime();
            System.out.println("Query 7: " + (l72-l71)/1000000);
            
            q = "SELECT * FROM Follows INNER JOIN User ON Follows.follower_id=User.uid INNER JOIN User as User2 ON Follows.following_id=User2.uid WHERE User.is_verified = False AND User2.is_verified = True;";
            long l81 = System.nanoTime();
            stmt.executeQuery(q);
            long l82 = System.nanoTime();
            System.out.println("Query 8: " + (l82-l81)/1000000);
            
            q = "SELECT * from TWEET WHERE time_stamp > '2015-12-31' AND time_stamp < '2021-01-01';";
            long l91 = System.nanoTime();
            stmt.executeQuery(q);
            long l92 = System.nanoTime();
            System.out.println("Query 9: " + (l92-l91)/1000000);
            
            q = "SELECT * from User WHERE username LIKE '%a%' OR username LIKE '%A%';";
            long l01 = System.nanoTime();
            stmt.executeQuery(q);
            long l02 = System.nanoTime();
            System.out.println("Query 10: " + (l02-101)/1000000);
            //System.out.println();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
