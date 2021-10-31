/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.util.*;
/**
 *
 * @author aabha
 */
public class NewClass1 {
    public static HashMap<String, Integer> s = new HashMap<String,Integer>();
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void permute(String str, int l, int r, int n) {
        if (l == r){
           s.putIfAbsent(str, l);
        }
            //System.out.println(str);
        else {
            for (int i = l; i <= r; i++){
                str = swap(str,l,i);
                permute(str, l+1, r,n);
                str = swap(str,l,i);
            }
        }
    }
    
    public static int fn2(int n) {
        String a = Integer.toString(n);
        permute(a,0,a.length()-1, n);
        int c=0;
        for (String key : s.keySet()) {
            System.out.println(key);
            if(key.charAt(0) == '0') {
                continue;
            } c++;
        }
        return c;
    }
    
    public static int fact(int z) {
        int a = 1;
        while(z>1) {
            a = a*z;
            z--;
        }
        return a;
    }
    public static int fact2(int c, int arr[]) {
        int z = fact(c);
        arr[0]--;
        for(int i=0; i<arr.length; i++) {
            
            if(arr[i] >1) {
                z = z/arr[i];
            }
        }        
        return z;
    }
    public static int fn(int n) {
        int[] arr = new int[9];
        int m = n;
        for(int i=0; i<arr.length; i++) {
            arr[i] = 0;
        } int c=0;
        boolean f = false;
        while(n>0) {
            int x = n%10;
            n = n/10;
            if(x==0) {
                f = true;
            }
            arr[x]++; c++;
            //n = n/10;
        } int r = 0;
        System.out.println(c);
        if(f) {
            //arr[0] = 0;
            r = fact2(c-1, arr);
        }
              
        return fact2(c,arr)-r;
    }
    
    public static void main(String[] args) {
        System.out.println(fn2(120));
    }
}
