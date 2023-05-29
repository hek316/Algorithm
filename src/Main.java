import java.io.*;

public class Main {

    public int plus123(int[] d,int n){
        if (d[n] > 0) {
            return d[n];
        }
        if (n == 1 || n == 2 || n == 3) {
            d[1] = 1;
            d[2] = 2;
            d[3] = 4;
            return d[n];
        }

        d[n] =  plus123(d,n-1) + plus123(d,n-2) +  plus123(d,n-3);

        return d[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        int[] d = new int[12];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            int n1 = Integer.parseInt(br.readLine());
            sb.append(main.plus123(d, n1)).append("\n");
        }

        System.out.println(sb);

    }
}
