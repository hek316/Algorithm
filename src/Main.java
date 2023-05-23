import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        ex 11 일 경우 11 -> 10 -> 9   두번 빼고 3으로 나누므로 나머지 2더함
         10 일 경우 -> 9 한번 빼고 3으로 나누므로 나머지 1 더함
     */

    static int  makeOne(int n1, int cnt){

        if (n1 < 2){
            return cnt;
        }
        return  Math.min(makeOne(n1/2, cnt +1 + n1%2),makeOne(n1/3, cnt +1 + n1%3) );

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int cnt =0;
        System.out.println(makeOne(n1, cnt));

    }
}