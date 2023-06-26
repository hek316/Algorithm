import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] f = new long[100001][4];
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000009;

        f[1][1] = 1;
        f[2][2] = 1;
        f[3][1] = 1;
        f[3][2] = 1;
        f[3][3] = 1;

        for(int i=4; i<=100000; i++){
            f[i][1]=(f[i-1][2] + f[i-1][3])% mod;
            f[i][2]=(f[i-2][3] + f[i-2][1])% mod;
            f[i][3]=(f[i-3][1] + f[i-3][2])% mod;
        }

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append((f[k][1]+f[k][2] + f[k][3])%mod).append("\n");
        }
        System.out.println(sb);

    }
}