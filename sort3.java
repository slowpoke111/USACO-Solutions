package previous;/*
TASK: previous.sort3
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class sort3 {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter writer;
    public static void p(Object x){
        if (x.getClass().isArray()){
            System.out.println(Arrays.toString((int[])(x)));
        }
        else{
            System.out.println(x);
        }

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
        br = new BufferedReader(new FileReader("previous.sort3.in"));
        //st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.sort3.out")));
        int N=i(br.readLine());
        int[] x = new int[N];

        for (int i=0;i<N;i++){
            x[i]=i(br.readLine());
        }

        int[][] y = new int[4][4];

        int[] sorted = x.clone();
        Arrays.sort(sorted);

        for (int i=0;i<N;i++){
            if (sorted[i]!=x[i]){
                y[sorted[i]][x[i]]+=1;
            }
        }

        //p(Arrays.deepToString(y));

        int num = 0;

        for (int i = 1;i<4;i++){
            for (int j=1;j<4;j++){
                if (y[i][j]!=0 && y[j][i]!=0){
                    int z = Math.min(y[i][j], y[j][i]);
                    y[i][j]-=z;
                    y[j][i]-=z;
                    num+=z;
                }
            }
        }
        //p(num);
        //p(Arrays.deepToString(y));

        int num2=0;

        for (int[] a:y){
            for (int b:a){
                num2+=2*b;
            }
        }
        num+=num2/3;
        //p(num);
        writer.println(num);
        writer.close();
        br.close();
    }
}
