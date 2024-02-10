import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] broken;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = Math.abs(k-100);
        if(n == 0){
            System.out.println(Math.min(Integer.toString(k).length(), min));
        }else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            broken = new int[n];
            for(int i=0; i<n; i++){
                broken[i] = Integer.parseInt(st.nextToken());
            }
            int tmp = k;

            while(tmp <= 1000000){
                int len =isPossible(tmp);
                if(len != 0){
                    min = Math.min(min,len + Math.abs(tmp-k));
                    break;
                }else {
                    tmp++;
                }
            }

            int tmp2 = k;
            while(tmp2 >= 0){
                int len =isPossible(tmp2);
                if(len != 0){
                    min = Math.min(min,len + Math.abs(tmp2-k));
                    break;
                }else {
                    tmp2--;
                }
            }

            System.out.println(min);
        }
    }

    private static int isPossible(int k){
        if(k == 0){
            for(int i=0; i <broken.length; i++){
                if(broken[i] == k){
                    return 0;
                }
            }
            return 1;
        }
        int len = 0;
        while (k > 0){
            for(int i=0; i <broken.length; i++){
                if(broken[i] == k % 10){
                    return 0;
                }
            }
            len++;
            k /= 10;
        }
        return len;
    }

}