import java.io.IOException;

public class Main {

    static int nextInt() throws IOException {
        int sum = 0;

        boolean isNegative = false;
        while(true) {
            int a = System.in.read();
            if(a == ' ' || a == '\n') {
                return isNegative ? sum * (-1) : sum;
            } else if(a == '-') {
                isNegative = true;
            } else if(a >= '0' && a <= '9') {
                sum = sum * 10 + a - '0';
            }
        }

    }

    public static void main(String[] args) throws Exception {

        int n = nextInt();

        int[] arr = new int[n];
        int[] cnt = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = nextInt();
        }

        int max = 1;
        cnt[0] = 1;
        for (int i=1; i<n; i++) {
            for(int j=0; j<i; j++){
                if( arr[j] > arr[i]){
                    cnt[i] = Math.max(cnt[j], cnt[i]);
                }
            }
            cnt[i]++;
            max = Math.max(max, cnt[i]);
        }
        System.out.println(max);
    }

}
