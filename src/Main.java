import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int MAX;
    static int[] days;
    static int[] cost;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        days = new int[N+1];
        cost = new int[N+1];

        for(int i=1; i<= N; i++){
            String[] s1 = br.readLine().split(" ");
            days[i] =  Integer.parseInt(s1[0]);
            cost[i] =  Integer.parseInt(s1[1]);
        }
        go( 1, 0);
        System.out.println(MAX);

    }

    public static void go(int day, int sum){
        if(day >= N+1){
            MAX = Math.max(sum, MAX);
            return;
        }

        // 선택안한 경우
        go(day+1, sum);
        // 불가능한 경우
        if(day+days[day] > N+1){
            return;
        }
        // 선택한 경우
        go(day+days[day],sum + cost[day]);
    }

}