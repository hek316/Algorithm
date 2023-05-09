import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean[] eratos(int n2){
        boolean[] isCompositeNumber = new boolean[n2+1];
        for (int i = 2; i <= n2; i++) {
            if (isCompositeNumber[i]) {
                continue;
            }
            for (int j = 2; j*i <= n2; j++) {
                isCompositeNumber[i*j] = true;
            }
        }
        return isCompositeNumber;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        boolean[] isCompositeNumber = eratos(n2);
        StringBuilder sb = new StringBuilder();
        if (n1 == 1) {
            n1++;
        }
        for (int i = n1; i <= n2; i++) {
            if(!isCompositeNumber[i]){
                sb.append(i).append("\n");
            }

        }

        System.out.println(sb);
    }
}