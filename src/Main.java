import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 10007;

        int[][] dp = new int[10][n+1];
        for(int i=0; i<=9; i++){
            dp[i][1] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int k=0; k<=9; k++) {
                for(int j=0; j<=k; j++){
                    dp[k][i] += dp[j][i-1];
                    dp[k][i] %= mod;
                }
            }
        }

        int result = 0;
        for(int j=0; j<=9; j++){
            result += dp[j][n];
            result %= mod;
        }
        System.out.println(result);

    }
}
