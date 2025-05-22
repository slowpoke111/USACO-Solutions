package previous;/*
TASK: previous.numtri
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class numtri{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("previous.numtri.in"));
        int R = Integer.parseInt(br.readLine());
        int[][] triangle = new int[R][R];

        for (int i=0;i<R;i++){
            StringTokenizer x = new StringTokenizer(br.readLine());
            for (int j=0;j<=i;j++){
                triangle[i][j] = Integer.parseInt(x.nextToken());
            }
        }

        br.close();

        //System.out.println(Arrays.deepToString(triangle));

        for (int i=R-2;i>=0;i--) {
            for (int j = 0; j < i+1; j++) {
                //System.out.println(i+" "+j);
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.numtri.out")));
        writer.println(triangle[0][0]);
        writer.close();
    }
}