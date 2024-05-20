import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int sum;

    static int cnt;

    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);

        if(sum == 0) cnt--;
        System.out.println(cnt);
    }

    public static void find(int idx,int total){
        if(idx == N){
            if(total == sum){
                cnt++;
            }
            return;
        }
        find(idx+1, total + arr[idx]);
        find(idx+1, total);
    }
}