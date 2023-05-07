import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int gcd(int num1, int num2){

        if (num2 == 0) {
            return  num1;
        }
        return gcd( num2,  num1%num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            s[i] = br.readLine();
            String[] num = s[i].split(" ");
            int num1 = Integer.parseInt(num[0]);
            int num2 =  Integer.parseInt(num[1]);
            // num1 이 num2 보다 큰 수가 되도록
            if (num2 > num1) {
                int tmp  = num1;
                num1 = num2;
                num2 = tmp;
            }
            sb.append(num1*num2/Main.gcd(num1, num2)).append("\n");
        }
        System.out.println(sb);

    }
}