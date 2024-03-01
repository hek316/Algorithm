import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        long sum = 0;

        int len = 1;
        for(int start=1, end=1; start<=n; len++){
            end=start*10-1;
            if(end > n){
                end = n;
            }
            sum+= (end-start +1)*len;
            start=start*10;

        }

        System.out.println(sum);
    }
}