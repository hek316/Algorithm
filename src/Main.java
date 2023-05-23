import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long  GCD(int n1, int n2){
        int min = n1;
        if (n2 < n1) {
            min = n2;
        }
        long gcd = 1;
        for (int i = min; i > 0; i--) {
            if (n1%i ==0 && n2%i ==0) {
                gcd = i;
                break;
            }

        }
        return gcd;
    }
    public static void main(String[] args) throws IOException {
         /*
          합이 int 의 값의 범위를 초과할 수 있으므로 long  형으로 선언
          */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n1--> 0){
            String st = br.readLine();
            String[] s = st.split(" ");
            int cnt =Integer.parseInt(s[0]);
            int[] num = new int[cnt];
            for (int i=0; i < cnt; i++) {
                num[i] = Integer.parseInt(s[i+1]);
            }

            long sum = 0;
            for (int i=0; i < num.length; i++) {
                for (int j=i +1; j < num.length; j++) {
                    sum +=GCD(num[i], num[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}