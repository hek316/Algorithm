import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        int E = 15;
        int S = 28;
        int M = 19;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e  = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int a = 0;
        int b = 0;
        int c = 0;


        while (true) {
            a++;
            b++;
            c++;
            if (a > E) {
                a = 1;
            }
            if (b > S) {
                b = 1;
            }
            if (c > M) {
                c = 1;
            }

            if (a == e &&  b == s && c == m) {
                System.out.println(cnt);
                break;
            } else  {
                cnt++;
            }
        }

    }
}