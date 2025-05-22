package previous;/*
TASK: previous.holstein
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class holstein {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter writer;
    static int[][] feed;

    static int[] requirements;

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

    public static void search(int currFeed, ArrayList<Integer> includedFeeds, int[] vitamins, ArrayList<Integer[]> output){

        if (currFeed==feed.length){

            for (int i=0;i<vitamins.length;i++) {
                if (vitamins[i] < requirements[i]) {
                    return;
                }
            }

            output.add(includedFeeds.toArray(new Integer[0]));

            return;
        }

        search(currFeed+1,includedFeeds,vitamins, output);
        
        includedFeeds.add(currFeed);
        for (int i=0;i<vitamins.length;i++){
            vitamins[i]+=feed[currFeed][i];
        }
        search(currFeed+1,includedFeeds,vitamins, output);

        includedFeeds.remove(includedFeeds.size()-1);
        for (int i=0;i<vitamins.length;i++){
            vitamins[i]-=feed[currFeed][i];
        }


    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("previous.holstein.in"));
        //st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.holstein.out")));

        int V = i(br.readLine());
        requirements = new int[V];

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<V;i++){
            requirements[i]=i(st.nextToken());
        }

        int G = i(br.readLine());

        feed = new int[G][V];

        for (int i=0;i<G;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<V;j++){
                feed[i][j] = i(st.nextToken());
            }
        }
        ArrayList<Integer[]> x = new ArrayList<>();
        search(0,new ArrayList<>(),new int[V], x);

        int best = 0;

        for (int i=0;i<x.size();i++){
            Integer[] xI = x.get(i);

            if (xI.length < x.get(best).length){
                best=i;
            }

            else if (xI.length == x.get(best).length){
                int sum = 0;
                int bestSum = 0;

                for (int j=0;j<xI.length;j++) {
                    sum += xI[j];
                    bestSum+=x.get(best)[j];
                }

                if (sum<bestSum){
                    best = i;
                }
            }
        }

        writer.print(x.get(best).length+" ");

        for (int i = 0; i<x.get(best).length-1;i++){
            writer.print((x.get(best)[i]+1)+" ");
        }

        writer.print((x.get(best)[x.get(best).length-1]+1));

        writer.println();

        writer.close();
        br.close();

    }
}
