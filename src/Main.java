import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder eratos(int n1, int n2){
        boolean[] isCompositeNumber = new boolean[n2+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n2; i++) {
            if (isCompositeNumber[i]) {
                continue;
            }
            for (int j = 2; j*i <= n2; j++) {
                isCompositeNumber[i*j] = true;
            }
            if(i>= n1 && i <= n2){
                sb.append(i).append("\n");
            }
        }
        return sb;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        StringBuilder sb = eratos(n1, n2);
        System.out.println(sb);
    }
}