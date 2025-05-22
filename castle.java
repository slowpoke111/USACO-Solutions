package previous;/*
TASK:previous.castle
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import  java.util.*;

public class castle {
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

    public static ArrayList<Integer> getRoomSizes(int[][] input, int N,int M){
        ArrayList<Integer> rooms = new ArrayList<>();

        boolean[][] visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]) {
                    rooms.add(fillRecursive(input, visited, i, j));
                }
            }
        }

        Collections.sort(rooms,Collections.reverseOrder()); //type:ignore
        return rooms;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("test.in"));
        st = new StringTokenizer(br.readLine());
        writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\BenGB\\Downloads\\castle_bronze_ioi\\1.out")));

        int M = i(st.nextToken());
        int N = i(st.nextToken());

        int[][] input = new int[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                input[i][j] = i(st.nextToken());
            }
        }

        ArrayList<Integer>rooms = getRoomSizes(input, N, M);

        writer.println(rooms.size());
        writer.println(rooms.get(0));

        int largest = -1;
        int x = -1;
        int y = -1;
        char direction = '_';

        for (int j=0;j<M;j++){
            for (int i=N-1;i>=0;i--){

                if (i!=0 && wallNorth(input[i][j])){
                    input[i][j] -= 2;
                    input[i-1][j] -= 8;

                    int a = getRoomSizes(input,N,M).get(0);
                    if (largest<a){
                        largest=a;
                        x=i+1;
                        y=j+1;
                        direction='N';
                    }

                    input[i][j]+=2;
                    input[i-1][j] += 8;
                }

                if (j!=M-1 && wallEast(input[i][j])) {
                    input[i][j] -= 4;
                    input[i][j + 1] -= 1;

                    int a = getRoomSizes(input, N, M).get(0);
                    if (largest < a) {
                        largest = a;
                        x = i + 1;
                        y = j + 1;
                        direction = 'E';
                    }

                    input[i][j]+=4;
                    input[i][j+1] += 1;
                }
            }
        }

        writer.println(largest);
        writer.println(x+" "+y+" "+direction);

        writer.close();
        br.close();

    }

    public static int fillRecursive(int[][] castle, boolean[][] visited, int x, int y) {

        // check to stay inbounds
        if (x < 0 || x > castle.length-1) return 0;
        if (y < 0 || y > castle[0].length-1) return 0;

        if (visited[x][y]) return 0;

        visited[x][y] = true;

        int z = 1;

        if (!wallNorth(castle[x][y])) z+=fillRecursive(castle, visited, x-1, y);
        if (!wallSouth(castle[x][y])) z+=fillRecursive(castle, visited, x+1, y);
        if (!wallWest(castle[x][y])) z+=fillRecursive(castle, visited, x, y-1);
        if (!wallEast(castle[x][y])) z+=fillRecursive(castle, visited, x, y+1);

        return z;
    }

    public static boolean wallSouth(int n){
        return (n>>3)%2 != 0;
    }
    public static boolean wallEast(int n){
        return (n>>2)%2 != 0;
    }
    public static boolean wallNorth(int n){
        return (n>>1)%2 != 0;
    }
    public static boolean wallWest(int n){
        return (n>>0)%2 != 0;
    }


}
