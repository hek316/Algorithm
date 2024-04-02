import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s1 = input.split(" ");


        while(!s1[0].equals("0")){
            int n = Integer.parseInt(s1[0]);
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(s1[i+1]);
            }
            input = br.readLine();
            s1 = input.split(" ");
            s1[0] = input.split(" ")[0];

            int[] result = new int[6];
            nextArr(0, result, arr, 0);
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void nextArr(int idx, int[] result,int[] arr, int start){
        if(idx == 6){
            for(int i=0; i<6; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<arr.length; i++){
            result[idx] = arr[i];
            nextArr(idx+1, result, arr, i+1);
        }
    }

}