/*
TASK:
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class template {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter writer;
    public static void p(Object x){
        System.out.println(x);
    }

    public static int i(Object x){
        if (x instanceof Double || x instanceof Float){
            return (int)(x);
        }

        else{
            return Integer.parseInt((String)(x));
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("test.in"));
        //st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));


        writer.close();
        br.close();

    }
}
