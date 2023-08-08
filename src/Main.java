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

        long[][] arr = new long[k+1][n+1];
        for(int i = 1; i <=k; i++){
            arr[i][0] = 1;
        }
        for(int i = 1; i <=n; i++){
            arr[1][i] = 1;
            for(int j = 2;  j <= k; j++) {
                arr[j][i] = (arr[j-1][i] +  arr[j][i - 1])%mod;
            }
        }

        System.out.println(arr[k][n]%mod);
    }
}
