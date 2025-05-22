package previous;/*
TASK:
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class cowdance {
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

    public static int concert(int size,int[] cows){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<size; i++){
            queue.add(cows[i]);
        }

        for (int i=0;i<cows.length-size;i++){
            int x = queue.poll();
            queue.add(cows[i+size]+x);
        }

        int x=0;
        while (!queue.isEmpty()){
            x = queue.poll();
        }

        return x;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("previous.cowdance.in"));
        st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.cowdance.out")));

        int N = i(st.nextToken());
        int maxTime = i(st.nextToken());
        int[] danceT = new int[N];

        for (int i = 0; i < N; i++){
            danceT[i] = i(br.readLine());
        }

        for (int i=1; i<N+1; i++){
            if (concert(i,danceT)<=maxTime){
                writer.println(i);
                break;
            }
        }

        writer.close();
        br.close();

    }
}
