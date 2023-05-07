import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int lcm(int num1, int num2){
        int big ;
        if (num1 > num2) {
            big = num1;
        } else {
            big = num2;
        }

        while (true){
            if (big % num1 == 0 && big % num2 == 0){
                break;
            }
            big++;
        }

        return big;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        StringBuilder sb = new StringBuilder();
        Main main = new Main();
        for (int i=0; i < n; i++) {
            s[i] = br.readLine();
            String[] num = s[i].split(" ");
            int num1 = Integer.parseInt(num[0]);
            int num2 =  Integer.parseInt(num[1]);
            sb.append(main.lcm(num1, num2)).append("\n");
        }

        System.out.println(sb);

    }
}