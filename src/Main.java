public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int k = read();
            int[][] dp = new int[2][100000];

            for(int i=0; i<k; i++)  dp[0][i] = read();
            for(int i=0; i<k; i++)  dp[1][i] = read();

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];

            for (int j=2; j< k; j++){
                int max = Math.max(dp[0][j-2],dp[1][j-2]);
                dp[0][j] += Math.max(dp[1][j-1], max) ;
                dp[1][j] += Math.max(dp[0][j-1], max);
            }
            sb.append(Math.max(dp[0][k-1],dp[1][k-1])).append("\n");
        }
        System.out.println(sb);

    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }

}
