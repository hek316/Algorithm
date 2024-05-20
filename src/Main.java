import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int sum = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int cnt = 0;
        for (int i = 1; i < (1 << N); i++) {
            int total = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    total+= arr[j];
                }
            }
            if(total == sum){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}