package previous;/*
TASK:
ID: roobeel1
LANG: JAVA
 */

import java.io.*;
import java.util.*;


public class citystate {
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
        br = new BufferedReader(new FileReader("previous.citystate.in"));

        writer = new PrintWriter(new BufferedWriter(new FileWriter("previous/citystate.out")));

        int N = i(br.readLine());

        HashMap<String, Integer> cities = new HashMap<>();

        int pairs=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String city = st.nextToken().substring(0, 2);
            String state = st.nextToken();
            if (!city.equals(state)) {
                if (cities.containsKey(state + city)) {
                    pairs += cities.get(state + city);
                }

                if (!cities.containsKey(city + state)) {
                    cities.put(city + state, 1);
                } else {
                    cities.put(city + state, cities.get(city + state) + 1);
                }
            }
        }

        writer.println(pairs);

        writer.close();
        br.close();

    }
}
