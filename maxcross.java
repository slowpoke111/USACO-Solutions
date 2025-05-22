package previous;/*
TASK:
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class maxcross {
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
        br = new BufferedReader(new FileReader("previous.maxcross.in"));
        st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.maxcross.out")));

        int N = i(st.nextToken());
        int K = i(st.nextToken());
        int B = i(st.nextToken());

        int[] broken = new int[B];

        for (int i=0;i<B;i++){
            broken[i]=i(br.readLine())-1;
        }


        int[] brokenRange = new int[N];

        for (int i=0;i<B;i++){
            brokenRange[broken[i]] += 1;
        }

        for (int i=1;i<N;i++){
            brokenRange[i] += brokenRange[i-1];
        }

        int min = Integer.MAX_VALUE;
        for (int i=0;i<N-K;i++){
            int x = brokenRange[i+K]-brokenRange[i];
            if (x < min){
                min = x;
            }
        }

        writer.println(min);

        writer.close();
        br.close();

    }
}
