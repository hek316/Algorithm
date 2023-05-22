import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int  makeOne(int n1, int[] d){

        for(int i=2; i<= n1; i++){
            d[i] = 1 + d[i-1];
            if(i%2 == 0){
                int temp = 1 + d[i/2];
                if (temp < d[i]) {
                    d[i]  = temp;
                }
            }

            if(i%3 == 0){
                int temp = 1 + d[i/3];
                if (temp < d[i]) {
                    d[i]  = temp;
                }
            }
        }
        return d[n1];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int[] d = new int[n1+1];
        d[1] = 0;
        System.out.println(makeOne(n1, d));

    }
}