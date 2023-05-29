import java.io.*;

public class Main {

    public int solve2Ntile(int[] d,int n){
        if (d[n] > 0) {
            return d[n];
        }

        if (n == 1) {
            d[n] = 1;
            return d[n];
        } else if (n == 2) {
            d[n] = 3;
            return d[n];
        }
        d[n] = (solve2Ntile(d,n-1) + solve2Ntile(d,n-2)*2)%10007;
        return d[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        int[] d = new int[n+2];
        int i = main.solve2Ntile(d, n);
        System.out.println(i);

    }
}
