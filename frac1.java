package previous;/*
TASK: previous.frac1
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

class fraction implements Comparable<fraction>{
    int n;
    int d;

    fraction(int n1, int d1){
        n=n1;
        d=d1;
    }

    double v(){
        return n*1.0/d;
    }

    public int compareTo(fraction a){
        return (int)(Math.signum(a.v()-this.v()));
    }

    public boolean equals(fraction a){
        return this.v()==a.v();
    }

}

public class frac1 {
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
        br = new BufferedReader(new FileReader("previous.frac1.in"));
        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous.frac1.out")));

        int N=i(br.readLine());
        TreeSet<fraction> set = new TreeSet<>();

        for (int i=0;i<N+1;i++){
            for (int j=1;j<N+1;j++){
                if (i<=j) set.add(new fraction(i,j));
            }
        }

        for (fraction i:set.descendingSet()){
            p(i.n+"/"+i.d);
            writer.println(i.n+"/"+i.d);
        }

        writer.close();
        br.close();

    }
}