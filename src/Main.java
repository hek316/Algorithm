import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static int makeOne(int n, int[] d){

        if (n==1){
            return 0;
        }
        if (d[n] > 0){
            return d[n];
        }

        d[n] =  makeOne(n-1, d) +1;

        if (n%2 ==0) {
            int tmp = makeOne(n/2, d)+1;
            d[n]  = d[n] < tmp ? d[n]: tmp;
        }


        if (n%3 ==0) {
            int tmp = makeOne(n/3, d)+1;
            d[n]  = d[n] < tmp ? d[n]: tmp;
        }

        return d[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        System.out.println(makeOne(n, d));
    }
}