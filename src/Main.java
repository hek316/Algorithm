import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] increase = new int[n];
        int[] decrease = new int[n];


        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && increase[j] > increase[i]){
                    increase[i] = increase[j];
                }
            }
            increase[i] +=1;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(arr[j]<arr[i] && decrease[j] > decrease[i]){
                    decrease[i] = decrease[j];
                }
            }
            decrease[i] +=1;
        }
        int max = 0;
        int tmp = 0;

        for(int i=0; i<n; i++){
            tmp = increase[i] + decrease[i];
            if(max < tmp){
                max = tmp;
            }
        }
        max--;
        System.out.println(max);

    }

}
