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
        int[] result = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = nextInt();
        }

        result[0] = arr[0];
        int maxIdx = 0;
        for (int i=1; i<n; i++) {
            result[i] = arr[i];
            for(int j=i-1; j>=0; j--){
                if( arr[j] < arr[i] && result[i] < result[j] + arr[i]){
                    result[i] = result[j] + arr[i];

                    if (result[maxIdx] < result[i]) {
                        maxIdx = i;
                    }
                }
            }
        }
        System.out.println(result[maxIdx]);
    }

}
