package previous;/*
TASK:
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class haybales {
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

    public static int binarySearchR(int indexR, int indexL, int target, int[] haybales){

        if (target<haybales[0]) return -1;

        if (indexR-indexL<=0){
            return indexR;
        }

        int mid = (indexR+indexL+1)/2;

        if (haybales[mid]==target){
            return mid;
        }

        if (target<haybales[mid]) {
            return binarySearchR(mid-1,indexL,target,haybales);
        }

        else {
            return binarySearchR(indexR,mid,target,haybales);
        }
    }
    public static int binarySearchL(int indexR, int indexL, int target, int[] haybales){

        if (target>haybales[haybales.length-1]) return -1;

        if (indexR-indexL<=0){
            return indexL;
        }

        int mid = (indexR+indexL)/2;

        if (haybales[mid]==target){
            return mid;
        }

        if (target<haybales[mid]) {
            return binarySearchL(mid,indexL,target,haybales);
        }

        else {
            return binarySearchL(indexR,mid+1,target,haybales);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("previous.haybales.in"));
        st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.haybales.out")));

        int N = i(st.nextToken());
        int Q = i(st.nextToken());

        int[] haybales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i =0;i<N;i++){
            haybales[i] = i(st.nextToken());
        }

        Arrays.sort(haybales);

        for (int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int a = i(st.nextToken());
            int b = i(st.nextToken());

            int x = binarySearchR(N-1,0,b,haybales);
            int y = binarySearchL(N-1,0,a,haybales);
            if (x==-1 || y==-1){
                p(0);
                writer.println(0);
            }
            else{
                p((x-y)+1);
                writer.println((x-y)+1);
            }
        }

        writer.close();
        br.close();

    }
}
