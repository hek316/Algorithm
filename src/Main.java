import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    public static int getGCD(int n1 , int n2) {
        if (n2 == 0){
            return n1;
        }
        if (n1 > n2) {
            return getGCD(n2 ,n1%n2);
        }else {
            return getGCD(n1 ,n2%n1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        int n = Integer.parseInt(st.nextToken());
        int mark = Integer.parseInt(st.nextToken());

        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);

        int gcd =Math.abs(Integer.parseInt(st2.nextToken()) - mark);
        for (int i=1; i < n; i++) {
            gcd = getGCD(Math.abs(Integer.parseInt(st2.nextToken()) - mark), gcd);
        }

        System.out.println(gcd);

    }
}