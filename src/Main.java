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
        int a = 1;
        int b = 1;
        int c = 1;


        while (a != e || b != s || c != m) {
            a++;
            b++;
            c++;
            a = Math.max(a%(E+1),1);
            b = Math.max(b%(S+1),1);
            c = Math.max(c%(M+1),1);

            cnt++;
        }

        System.out.println(cnt);

    }
}