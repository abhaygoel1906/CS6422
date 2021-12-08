/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aabha
 */
import org.neo4j.driver.*;
import java.util.*;
import static org.neo4j.driver.Values.parameters;

class Thr extends Thread {
    
}

public class Test2Neo4j {
    private static Driver driver;
    
    public static void main(String[] args) {
        String srr[] = new String[10];
        
        try{
            String uri = "bolt://localhost:7687", u = "neo4j", p = "qwert123";
            driver = GraphDatabase.driver( uri, AuthTokens.basic(u, p));
            Session sess = driver.session();
            
            String q = "MATCH (n:Greeting) RETURN n";
            String m = "ABCD";
            Transaction tx = sess.beginTransaction();
            
            long l1 = System.nanoTime();
            Result rs = tx.run(q);
            long l2 = System.nanoTime();
            System.out.println("Query 1: " + (l2-l1)/1000000);
            
            q="MATCH (t:Tweet) where t.text contains 'http' and t.likes > 100 return t;";
            long l11 = System.nanoTime();
            rs = tx.run(q);
            long l12 = System.nanoTime();
            System.out.println("Query 1: " + (l12-l11)/1000000);
            
            q = "Match (u:User)-[:AT]->(g:Geo) where g.locn contains 'U.S' and not(u.bio is null) and not(u.dp is null) return u;";
            long l21 = System.nanoTime();
            rs = tx.run(q);
            long l22 = System.nanoTime();
            System.out.println("Query 2: " + (l22-l21)/1000000);
            
            q = "match (t:Tweet)-[:MENTIONED]->(u:User) return t;";
            long l31 = System.nanoTime();
            rs = tx.run(q);
            long l32 = System.nanoTime();
            System.out.println("Query 3: " + (l32-l31)/1000000);
            
            q = "MATCH (u:User)-[:Tweeted]->(t:Tweet) where t.likes < 30 and u.follower > 250 return t.tid;";
            long l41 = System.nanoTime();
            rs = tx.run(q);
            long l42 = System.nanoTime();
            System.out.println("Query 4: " + (l42-l41)/1000000);
            
            q = "match (t:Tweet) where t.retweets > t.likes return t;";
            long l51 = System.nanoTime();
            rs = tx.run(q);
            long l52 = System.nanoTime();
            System.out.println("Query 5: " + (l52-l51)/1000000);
            
            q = "match (u:User) where u.verified = true and u.follower > 1000 return u;";
            long l61 = System.nanoTime();
            rs = tx.run(q);
            long l62 = System.nanoTime();
            System.out.println("Query 6: " + (l62-l61)/1000000);
            
            q = "MATCH (g:Geo)<-[:AT]-(u:User)-[:Tweeted]->(t:Tweet) where not( g.locn contains 'US') return t;";
            long l71 = System.nanoTime();
            rs = tx.run(q);
            long l72 = System.nanoTime();
            System.out.println("Query 7: " + (l72-l71)/1000000);
            
            q = "MATCH (n)-[:FOLLOWS]->(m) where n.verified = true and m.verified = false return m;";
            long l81 = System.nanoTime();
            rs = tx.run(q);
            long l82 = System.nanoTime();
            System.out.println("Query 8: " + (l82-l81)/1000000);
            
            q = "MATCH (n:Tweet) where n.year > 2015 and n.year <2021 return n;";
            long l91 = System.nanoTime();
            rs = tx.run(q);
            long l92 = System.nanoTime();
            System.out.println("Query 9: " + (l92-l91)/1000000);
            
            q = "MATCH (n:User) where n.username contains 'A' or n.username contains 'a' return n;";
            long l01 = System.nanoTime();
            rs = tx.run(q);
            long l02 = System.nanoTime();
            System.out.println("Query 10: " + (l02-101)/1000000);
            
            //System.out.println( g );            
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!"+e.getMessage()+"!!!!!!!!!!!!!");
        }
    }
}
