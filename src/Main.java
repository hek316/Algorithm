import java.io.*;

public class Main {

    public int plus123(int[] d,int n){
        if(d[n] > 0){
            return d[n];
        }
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4; i<=n; i++){
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
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
