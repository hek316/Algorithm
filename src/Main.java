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
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int answer = 1;
        int e , s , m ;
        while (true) {
            e = answer%E;
            s = answer%S;
            m = answer%M;
            if (e == 0) e = E;
            if (s == 0) s = S;
            if (m == 0) m = M;
            if (e == arr[0] &&  s == arr[1] && m == arr[2]) {
                break;
            }else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}