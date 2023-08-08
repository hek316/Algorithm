import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int mod = 1000000000;

        long[][] arr = new long[n+1][k+1];
        for(int i = 0; i <=n; i++){
            arr[i][1] = 1;
        }
        for(int i = 2; i <= k; i++){
            for(int j = 0;  j <= n; j++) {
                for(int l = 0;  l <= j; l++) {
                    arr[j][i] += arr[l][i - 1]%mod;
                }
            }
        }

        System.out.println(arr[n][k]%mod);
    }
}
