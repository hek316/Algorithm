import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] ar = new int[n];
        // 자신보다 왼쪽에 있는 작은수 담기
        int[] cntAr = new int[n];
        // 영향받은 그 이전 인덱스 담기
        int[] idx = new int[n];


        for(int i=0; i < n; i++){
            ar[i] =Integer.parseInt(s[i]);
        }

        cntAr[0] =1;

        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if(ar[j] < ar[i] && cntAr[i] <= cntAr[j] +1){
                    cntAr[i] = cntAr[j] +1;
                    idx[i] = j;
                }
            }
            if(cntAr[i] == 0){
                cntAr[i] = 1;
            }
        }
        int max = 0;
        int maxIdx = 0;
        for(int i=0; i < n; i++){
            if(max < cntAr[i]){
                max = cntAr[i];
                maxIdx = i;
            }
        }


        StringBuilder sb = new StringBuilder();

        int[] val = new int[cntAr[maxIdx]];
        int tmp = maxIdx;
        for(int i =(cntAr[maxIdx]-1); i >=0; i-- ){
            val[i] = ar[tmp];
            tmp = idx[tmp];

        }

        sb.append(max).append("\n");
        for(int i= 0; i < val.length; i++){
            sb.append(val[i]).append(" ");
        }

        System.out.println(sb);

    }
}