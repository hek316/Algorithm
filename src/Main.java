import java.io.IOException;
import java.util.Arrays;

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
        int[] b = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = nextInt();
        }
        b[0] =  arr[0];
        int len = 0;

        for (int i=1; i<n; i++) {
            len = binarySearch( arr[i], len, b);

        }
        System.out.println(len + 1);
    }



    public static int binarySearch(int target, int len, int[] b){
        int start =0;

        if(b[len] > target ){
            len = len +1;
            b[len] = target;
            return  len;
        }
        int end = len;
        int mid = 0;

        while (start < end) {
            mid = (start + end)/2;
            if (target == b[mid]) {
                break;
            } else if (target > b[mid]) {
                end = mid;
            } else {
                start = mid+1;
                mid++;
            }
        }
        if ( target > b[mid]) {
            b[mid] = target;
        }
        return  len;
    }

}