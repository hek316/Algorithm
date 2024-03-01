import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long sum = 0;
        int n = Integer.parseInt(s);

        int i= 1;
        long k = (long) Math.pow(10, 0);
        long mok = n/10;
        while( (mok) >0 ){
            sum = sum + 9*(long) Math.pow(10, i-1)*i;
            i++;
            k = (long) Math.pow(10, i);
            mok = n/k;
        }

        long tmp = n- (long)Math.pow(10, i-1)+1;
        sum += tmp*s.length();


        System.out.println(sum);
    }



}