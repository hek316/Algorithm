import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        br.close();
        int[] memo = new int[max+1];
        if(max>3){
            memo[1] = 1;
            memo[2] = 2;
            memo[3] = 4;
            getOneTwoThreePlus(max, memo);
        }

        for(int i=0; i<n; i++){
            sb.append(getOneTwoThreePlus(arr[i], memo)).append("\n");
        }

        System.out.println(sb);

    }

    public static int getOneTwoThreePlus(int i, int[] memo){
        if(i< 2){
            return i;
        }
        if(i == 3){
            return 4;
        }
        if(memo[i] != 0){
            return memo[i];
        }else {
            return getOneTwoThreePlus(i-1, memo)+getOneTwoThreePlus(i-2, memo) +getOneTwoThreePlus(i-3, memo);
        }
    }



}