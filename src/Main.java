import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[] arr;

    static int[] result;

    static boolean[] isvisit;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        isvisit = new boolean[10];
        result = new int[N+1];

        String s = br.readLine();
        for(int i =0; i<N; i++){
            arr[i] = s.charAt(2*i);
        }

        solveMax(arr, isvisit, 0, result);
        Arrays.fill(isvisit, false);
        solve(arr, isvisit, 0, result);
        System.out.println(sb);
    }

    public static boolean solve(char[] arr, boolean[] isvisit, int idx, int[] result){
        if(idx ==  N+1){
            for(int i : result){
                sb.append(i);
            }
            sb.append("\n");
            return true;
        }

        for(int i=0; i<10; i++){
            if(isvisit[i] == true) continue;
            if(idx == 0 || isVaild(result[idx-1], i, arr[idx-1])){
                result[idx] = i;
                isvisit[i] = true;
                if(solve(arr, isvisit, idx+1, result)){
                    return true;
                }
                isvisit[i] = false;
            }
        }
        return false;
    }

    public static boolean solveMax(char[] arr, boolean[] isvisit, int idx, int[] result){
        if(idx ==  N+1){
            for(int i : result){
                sb.append(i);
            }
            sb.append("\n");
            return true;
        }

        for(int i=9; i>=0; i--){
            if(isvisit[i] == true) continue;
            if(idx == 0 || isVaild(result[idx-1], i, arr[idx-1])){
                result[idx] = i;
                isvisit[i] = true;
                if(solveMax(arr, isvisit, idx+1, result)){
                    return true;
                }
                isvisit[i] = false;
            }
        }
        return false;
    }
    public static boolean isVaild(int preNum, int num, char inequality ){
        if(inequality == '<'){
            if(preNum < num){
                return true;
            }
        }else{
            if(preNum > num){
                return true;
            }
        }
        return false;
    }
}