import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class circularBarn {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] bestMove = new int[(int)(5e6)]; // Implemnt preprocessing
    //static PrintWriter writer;
    public static void p(Object x){
        System.out.println(x);
    }

    public static int i(Object x){
        if (x instanceof Double || x instanceof Float || x instanceof Integer){
            return (int)(x);
        }

        else{
            return Integer.parseInt((String)(x));
        }
    }

    public static boolean[] findPrimes(int max){
        boolean[] primes = new boolean[max+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        for (int i = 2; i <= max; i++){
            if (!primes[i]){continue;}
            for (int j=2*i;j<=max;j+=i){
                primes[j] = false;
            }
        }
        return primes;
    }

    public static int getMoves(int cows, boolean[] primes){
        if (primes[cows]){return 1;}
        if (cows%4!=0){
            for (int i=cows;i>0;i-=4){
                if (primes[i]){
                    return 1+getMoves(cows-i,primes);
                }
            }
            return i(cows/2);
        }
        else{return i(cows/2);}
    }

    public static boolean solve(int[] cows, boolean[] primes){

        for (int i=0;i<cows.length;i++){
            if (bestMove[cows[i]]==0) {
                bestMove[cows[i]] = getMoves(cows[i], primes);
            }
        }

        int min = Integer.MAX_VALUE;
        boolean win=false;// true if john win
        for (int i=0;i<cows.length;i++){
            if (bestMove[cows[i]]/2<min){
                min = bestMove[cows[i]]/2;
                win=bestMove[cows[i]]%2!=0;
            }
        }

        return win;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new FileReader("test.in"));

        int T = i(br.readLine());

        boolean[] primes = findPrimes((int)(5e6));

        for (int t = 0; t < T; t++){
            int N = i(br.readLine());
            int[] cows = new int[N];
            st=new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                cows[i] = i(st.nextToken());
            }

           p(solve(cows,primes)?"Farmer John":"Farmer Nhoj");
        }
        

        br.close();

    }
}
