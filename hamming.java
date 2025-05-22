package previous;/*
TASK: previous.hamming
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class hamming {
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
        br = new BufferedReader(new FileReader("previous.hamming.in"));
        st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.hamming.out")));


        int N = i(st.nextToken());
        int B = i(st.nextToken());
        int D = i(st.nextToken());

        ArrayList<Integer> x = new ArrayList<>();
        x.add(0);

        for (int i=0;i<Math.pow(2,B);i++){
            boolean y = false;
            if (x.size()>=N){break;}

            for (int j:x) {
                if (Integer.bitCount((i^j))<D){
                    y=true;
                    break;
                }
            }
            if (!y){
                x.add(i);
            }
        }

        for (int i=0;i<x.size();i++){
            if (i%10==0) writer.println("\b");
            writer.print(x.get(i)+" ");
        }
        if (N%10!=0) writer.println();

        writer.close();
        br.close();

    }
}
