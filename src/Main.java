import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MIN;
    static int[] row;
    static int[] column;
    static int totalSum = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new int[N];
        column = new int[N];
        MIN = Integer.MAX_VALUE;

        for(int i=0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                row[i] += num;
                column[j] += num;
                totalSum += num;
            }
        }
        go(0,totalSum,0);
        System.out.println(MIN);

    }

    public static void go(int idx, int totalSum, int cnt){
        if(idx == N){
            return;
        }
        if(cnt == N/2){
            // 두 팀의 능력치 차
            int absSum =Math.abs(totalSum);
            MIN = Math.min(absSum, MIN);
            return;
        }
        // 선택한 경우
        go(idx+1, totalSum - row[idx] - column[idx], cnt+1);
        // 선택안한 경우
        go(idx+1, totalSum, cnt);


    }

}