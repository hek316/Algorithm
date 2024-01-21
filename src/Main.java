import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int max = 1;
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                swapRight(arr, i, j);
                max = Math.max(count(arr,i,j), max);
                max = Math.max(count(arr,i,j+1), max);
                swapRight(arr, i, j);
            }
        }

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                swapDown(arr, i, j);
                max = Math.max(count(arr,i,j), max);
                max = Math.max(count(arr,i+1,j), max);
                swapDown(arr, i, j);;
            }
        }
        System.out.println(max);
    }

    static char[][] swapRight (char[][] arr, int i, int j){
        char tmp = arr[i][j+1];
        arr[i][j+1] =  arr[i][j];
        arr[i][j] = tmp;
        return arr;
    }

    static char[][] swapDown (char[][] arr, int i, int j){
        char tmp = arr[i+1][j];
        arr[i+1][j] =  arr[i][j];
        arr[i][j] = tmp;
        return arr;
    }

    static int count(char[][] arr,int i, int j){
        int max = 1;
        int cnt1 = 1;
        for(int k=j-1; k>=0; k--){
            if(arr[i][j] == arr[i][k]){
                cnt1++;
            }else {
                break;
            }
        }

        for(int k=j+1; k<arr.length; k++){
            if(arr[i][j] == arr[i][k]){
                cnt1++;
            }else {
                break;
            }
        }

        int cnt2 = 1;
        for(int k=i-1; k>=0; k--){
            if(arr[i][j] == arr[k][j]){
                cnt2++;
            }else {
                break;
            }
        }

        for(int k=i+1; k<arr.length; k++){
            if(arr[i][j] == arr[k][j]){
                cnt2++;
            }else {
                break;
            }
        }
        max = Math.max(cnt1, cnt2);

        return max;
    }




}