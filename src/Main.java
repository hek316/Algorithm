import java.io.*;

public class Main {

    public int solve2Ntile(int[] d,int n){
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i<=n; i++) {
            d[i] = (d[i-1] + d[i-2]*2)%10007;
        }

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
