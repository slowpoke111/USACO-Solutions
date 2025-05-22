package previous;/*
TASK: previous.pprime
ID: roobeel1
LANG: JAVA
 */


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {

    static ArrayList<Integer> palindromes = new ArrayList<>();

    public static void palindromes(String soFar, int remaining){
        if (remaining<=0){
            int offset = remaining==0?-1:-2;
            int length = soFar.length();
            for (int i=length+offset;-1<i;i--){
                soFar+=soFar.charAt(i);
            }
            if (soFar.charAt(0)!='0'){palindromes.add(Integer.parseInt(soFar));}


            return;
        }
        for (int i=0;i<=9;i++){
            palindromes(soFar+i,remaining-2);
        }
    }

    public static boolean isPrime(int n){
        for (int i=2;i<Math.sqrt(n)+1;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("previous.pprime.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lower = Integer.parseInt(st.nextToken());
        int upper = Integer.parseInt(st.nextToken());
        for (int i = 1;i<9;i++){palindromes("",i);}

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.pprime.out")));

        for (int i:palindromes){
            if (lower<=i && i<=upper && isPrime(i)){
                writer.println(i);
            }
        }

        writer.close();
        br.close();

    }
}
