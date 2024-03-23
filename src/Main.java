import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String s  = nextArr(arr, n);
        System.out.println(s);
    }

    static private String nextArr(int[] arr, int n){
        int idx = n-1;
        // 마지막 순열일 경우 내림차순
        while(idx>=1 && arr[idx-1] > arr[idx] ){
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        if(idx == 0){
            sb.append("-1");
            return sb.toString();
        }

        int j = idx-1;
        for(int i = n-1; i>= idx; i--){
            if(arr[j] < arr[i]){
                swap(i, j, arr);
                break;
            }
        }

        j = n-1;
        while(idx < j){
            swap(idx, j, arr);
            idx++;
            j--;
        }


        for(int i=0; i<= arr.length-1; i++){
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    private static void swap(int i, int j, int[] arr){
        int tmp =arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
