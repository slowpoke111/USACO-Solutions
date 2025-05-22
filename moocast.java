package previous;

import java.io.*;
import java.util.*;

public class moocast {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter writer;

    public static void p(Object x){
        System.out.println(x);
    }

    public static int i(Object x) {
        if (x instanceof Double || x instanceof Float) {
            return (int) (x);
        } else {
            return Integer.parseInt((String) (x));
        }
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("previous.moocast.in"));
        //st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.moocast.out")));

        int N = i(br.readLine());

        ArrayList<TreeSet<Integer>> graph = new ArrayList<TreeSet<Integer>>();
        int[][] cows = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = i(st.nextToken());
            int y = i(st.nextToken());
            int p = i(st.nextToken());

            graph.add(new TreeSet<Integer>());
            cows[i] = new int[]{x,y,p};

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i==j){continue;}

                int[] cow1 = cows[i];
                int[] cow2 = cows[j];

                if (Math.sqrt((Math.pow(cow1[0]-cow2[0],2)+(Math.pow(cow1[1]-cow2[1],2))))<=cow1[2]){
                    graph.get(i).add(j);
                }
            }
        }


        int best=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ArrayDeque<Integer> toVisit = new ArrayDeque();
            boolean[] visited = new boolean[N];
            toVisit.push(i);

            int cowsFound = 1;
            visited[i] = true;

            while (!toVisit.isEmpty()){
                int curr=toVisit.pop();
                for (int j:graph.get(curr)){
                    if (!visited[j]) {
                        cowsFound++;
                        toVisit.push(j);
                        visited[j] = true;
                    }
                }
            }

            if (cowsFound>best){
                best=cowsFound;
            }
        }

        p(best);

        writer.println(best);

        writer.close();
        br.close();

    }
}
