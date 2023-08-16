public class Main {

    private static int read() throws Exception {

        int c, N = System.in.read() - 48;
        while ((c = System.in.read()) > 32) N = 10 * N + c - 48;

        return N;

    }

    public static void main(String[] args) throws Exception {

        int  n = read();
        int[][] arr = new int[n + 1][3];
        int[][] sum = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            int j = 0;
            while (j<3) {
                arr[i][j++] = read();
            }
        }

        sum[2][0] = Math.min(arr[1][1], arr[1][2] ) + arr[2][0];
        sum[2][1] = Math.min(arr[1][0], arr[1][2] ) + arr[2][1];
        sum[2][2] = Math.min(arr[1][0], arr[1][1] ) + arr[2][2];
        for (int a = 3; a <= n; a++) {
            sum[a][0] = Math.min(sum[a - 1][1], sum[a - 1][2]) + arr[a][0];
            sum[a][1] = Math.min(sum[a - 1][0], sum[a - 1][2]) + arr[a][1];
            sum[a][2] = Math.min(sum[a - 1][0], sum[a - 1][1]) +arr[a][2];
        }

        int min = Math.min(sum[n][0], Math.min(sum[n][1], sum[n][2]));
        System.out.println(min);
    }

}