import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];

        // 최소값을 구하는 문제이므로 최댓값 담아주기
        for(int j=1; j<= n; j++){
            num[j] = j;
            for(int i=1; i*i<= j; i++){
                if((num[j - (i * i)] + 1) < num[j]){
                    num[j] = num[j-i*i] +1 ;
                }
            }
        }
        System.out.println(num[n]);

    }
}
