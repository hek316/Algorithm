import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[2][n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0];
        dp[1][0] = arr[0];
        int max= dp[0][0];
        for (int i = 1; i < n; i++) {
            if (dp[0][i-1] > 0) {
                dp[0][i] = dp[0][i-1]+ arr[i];
            }else {
                dp[0][i] =arr[i];
            }

            max = Math.max(max,dp[0][i]);
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]+ arr[i]);
            }else {
                dp[1][i] =dp[1][i-1] + arr[i];
            }
            max = Math.max(max,dp[1][i]);
        }

        System.out.println(max);
    }

}
