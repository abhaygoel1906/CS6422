/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
//import org.neo4j.driver.*;
/**
 *
 * @author aabha
 */
class Thred extends Thread {
    int x;
    public Thred(int x) {
        this.x = x;
    }
    
    public void run() {
        System.out.println(System.currentTimeMillis());
        for(int i=x; i>0; i--) {
            System.out.print(i + " ");
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.print("!!!" + e.getMessage() + "!!!");
        }
        }
        System.out.println();
        System.out.println(System.currentTimeMillis());
    }
}

public class NewClass2 {
    public static void main(String[] args) {
        
        Thred x = new Thred(12), y = new Thred(10), z = new Thred(5);
        x.start(); y.start(); z.start();
        
        System.out.println(System.currentTimeMillis());
    }
}
