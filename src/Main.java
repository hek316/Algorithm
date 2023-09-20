import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] dp = new int[n][3];

        String[] s ;
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                rgb[i][j] = Integer.parseInt(s[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int k=0; k<3; k++){
            for(int j=0; j<3; j++){
                if(k==j){
                    dp[1][j] = 2001;
                }else {
                    dp[1][j] = rgb[0][k]+ rgb[1][j];
                }
            }
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }
            if (k==0) {
                min = Math.min(dp[n-1][2],min);
                min = Math.min(dp[n-1][1],min);
            }else if (k==1) {
                min = Math.min(dp[n-1][0],min);
                min = Math.min(dp[n-1][2],min);
            }else if (k==2) {
                min = Math.min(dp[n-1][1],min);
                min = Math.min(dp[n-1][0], min);
            }
        }
        System.out.println(min);
    }
}