import java.io.*;
import java.util.*;


public class hps {
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
        br = new BufferedReader(new FileReader("hps.in"));
        writer = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        int N = i(br.readLine());
        char[] moves = new char[N];
        int[] h = new int[N];
        int[] p = new int[N];
        int[] s = new int[N];
        
        for (int i=0;i<N;i++){
            moves[i] = br.readLine().charAt(0);
        }

        h[0] = moves[0]=='H'?1:0;
        p[0] = moves[0]=='P'?1:0;
        s[0] = moves[0]=='S'?1:0;

        for (int i=1;i<N;i++) {
            if (moves[i] == 'H') {
                h[i] = h[i - 1] + 1;
            }
            else {
                h[i]=h[i-1];
            }
        }
        for (int i=1;i<N;i++) {
            if (moves[i] == 'P') {
                p[i] = p[i - 1] + 1;
            }
            else {
                p[i]=p[i-1];
            }
        }
        for (int i=1;i<N;i++) {
            if (moves[i] == 'S') {
                s[i] = s[i - 1] + 1;
            }
            else {
                s[i]=s[i-1];
            }
        }
        int best = -Integer.MAX_VALUE;
        for (int i=0;i<N;i++){
            for (int j=0;j<3;j++){
                if (j==0){
                    best = Math.max(h[i]+(p[N-1]-p[i]),best);
                    best = Math.max(h[i]+(s[N-1]-s[i]),best);
                }
                else if (j==1){
                    best = Math.max(p[i]+(h[N-1]-h[i]),best);
                    best = Math.max(p[i]+(s[N-1]-s[i]),best);
                }
                else{
                    best = Math.max(s[i]+(h[N-1]-h[i]),best);
                    best = Math.max(s[i]+(p[N-1]-p[i]),best);
                }
            }
        }

        p(best);

        writer.println(best);

        writer.close();
        br.close();
    }
}
