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
    Transaction tx;
    String s;
    
    public Thr(Transaction tx, String s) {
        this .tx = tx;
        this.s = s;
    }
    public void run() {
        try{
            //long l1 = System.nanoTime();
            Result rs = tx.run(s);
            //long l2 = System.nanoTime();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Test2Neo4j {
    private static Driver driver;
    
    public static void main(String[] args) {
        String srr[] = new String[10];
        srr[0] = "MATCH (t:Tweet) where t.text contains 'http' and t.likes > 100 return t;";
        srr[1] = "Match (u:User)-[:AT]->(g:Geo) where g.locn contains 'U.S' and not(u.bio is null) and not(u.dp is null) return u;";
        srr[2] = "match (t:Tweet)-[:MENTIONED]->(u:User) return t;";
        srr[3] = "MATCH (u:User)-[:Tweeted]->(t:Tweet) where t.likes < 30 and u.follower > 250 return t.tid;";
        srr[4] = "match (t:Tweet) where t.retweets > t.likes return t;";
        srr[5] = "match (u:User) where u.verified = true and u.follower > 1000 return u;";
        srr[6] = "MATCH (g:Geo)<-[:AT]-(u:User)-[:Tweeted]->(t:Tweet) where not( g.locn contains 'US') return t;";
        srr[7] = "MATCH (n)-[:FOLLOWS]->(m) where n.verified = true and m.verified = false return m;";
        srr[8] = "MATCH (n:Tweet) where n.year > 2015 and n.year <2021 return n;";
        srr[9] = "MATCH (n:User) where n.username contains 'A' or n.username contains 'a' return n;";
        
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
            //System.out.println("Query 1: " + (l2-l1)/1000000);
            for(int i=0; i<srr.length; i++) {
                Thr temp = new Thr(tx, srr[i]);
                l1 = System.nanoTime();
            //Result rs = tx.run(s);
                temp.start();
                l2 = System.nanoTime();
                System.out.println((i+1)+": " + (l2-l1));
            }
            
            //System.out.println( g );            
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!"+e.getMessage()+"!!!!!!!!!!!!!");
        }
    }
}
