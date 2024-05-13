import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] answer = new int[n];

        String s = br.readLine();

        int k = 0;
        for(int i=0; i< n; i++){
            for(int j =i; j< n; j++){
                if(s.charAt(k) == '+'){
                    arr[i][j] = 1;
                }else if(s.charAt(k) == '-'){
                    arr[i][j] = -1;
                }else if(s.charAt(k) == '0') {
                    arr[i][j] = 0;
                }
                k++;
            }
        }
        getAnswer(answer, n, 0, arr);

    }

    public static boolean getAnswer(int[] answer, int n, int idx, int[][] arr){
        if(idx == n){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< n; i++){
                sb.append(answer[i]).append(" ");
            }
            System.out.println(sb);
            return true;

        }

        if(arr[idx][idx] == '0'){
            answer[idx] = 0;
            if(getAnswer(answer, n, idx+1, arr)){
                return true;
            }
        } else {
            for(int j =1; j<= 10; j++){
                answer[idx] = j*arr[idx][idx];
                if(isValid(answer, idx, arr) && getAnswer(answer, n, idx+1, arr) ){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int[] answer, int k, int[][] arr){
        for(int i=0; i<=k; i++){
            int sum = 0;
            for(int j=i; j<=k; j++){
                sum += answer[j];
            }
            if(sum > 0){
                if(arr[i][k] != 1 ){
                    return false;
                }
            } else if( sum < 0){
                if(arr[i][k] != -1 ){
                    return false;
                }
            } else if( sum == 0){
                if(arr[i][k] != 0 ){
                    return false;
                }
            }
        }
        return true;
    }

}