
public class Main {

    public static void main(String[] args) throws Exception {

        int column = read();
        int row = read();

        int[][] arr = new int[column][row];
        for(int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                arr[i][j] = read();
            }
        }
        int max = threeMax(arr);
        max = Math.max(twoMax(arr),max);
        System.out.println(max);

    }


    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while((c=System.in.read())>32) n = (n<<3) + (n<<1) + (c&15);
        return n;
    }

    static private  int threeMax(int[][] arr){
        int max = 0;

        // 세로로 3연속
        for(int i=0; i+2 < arr.length; i++){
            for(int j=0; j <arr[0].length; j++){
                int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j];
                if(j+1 < arr[0].length){
                    int tmp1 = Math.max(arr[i][j+1], arr[i+1][j+1]);
                    tmp1 = Math.max(tmp1, arr[i+2][j+1]);
                    max = Math.max(tmp1+ sum, max);
                }

                if(j- 1 >= 0){
                    int tmp1 = Math.max(arr[i][j-1], arr[i+1][j-1]);
                    tmp1 = Math.max(tmp1, arr[i+2][j-1]);
                    max = Math.max(tmp1+sum, max);
                }

                // 연속 4줄
                if(i+ 3 < arr.length){
                    max = Math.max(arr[i+3][j]+sum, max);
                }
            }
        }


        // 가로로 3연속
        for(int i=0; i< arr.length; i++){
            for(int j=0; j+2 <arr[0].length; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                if(i+1 < arr.length){
                    int tmp1 = Math.max(arr[i+1][j], arr[i+1][j+1]);
                    tmp1 = Math.max(tmp1, arr[i+1][j+2]);
                    max = Math.max(tmp1+ sum, max);
                }

                if(i- 1 >= 0){
                    int tmp1 = Math.max(arr[i-1][j], arr[i-1][j+1]);
                    tmp1 = Math.max(tmp1, arr[i-1][j+2]);
                    max = Math.max(tmp1+sum, max);
                }
                // 연속 4줄
                if(j+ 3 < arr[0].length){
                    max = Math.max(arr[i][j+3]+sum, max);
                }
            }
        }

        return max;
    }

    static int twoMax(int[][] arr) {
        int max = 0;
        //세로 연속2
        for (int i = 0; i+1 < arr.length; i++) {
            for(int j= 0; j < arr[0].length; j++){
                int sum = arr[i][j] + arr[i+1][j];
                if(j+1 < arr[0].length){
                    int tmp = arr[i][j+1] + arr[i+1][j+1];
                    if(i+2 < arr.length){
                        tmp = Math.max(tmp, arr[i+1][j+1] + arr[i+2][j+1]);
                    }
                    if(i-1 >= 0) {
                        tmp = Math.max(tmp, arr[i-1][j+1] + arr[i][j+1]);
                    }
                    max = Math.max(sum+ tmp, max);
                }
            }
        }
        // 가로연속
        for (int i = 0; i< arr.length-1; i++) {
            for(int j= 0; j+1 < arr[0].length; j++) {
                int sum = arr[i][j] +  arr[i][j+1];
                if(i + 1 < arr.length){
                    int tmp = 0;
                    if( j-1 >= 0 ){
                        tmp  = arr[i+1][j-1] +arr[i+1][j];
                    }
                    if( j+2 < arr[0].length){
                        tmp = Math.max(arr[i+1][j+1] +arr[i+1][j+2],tmp);
                    }
                    max  =Math.max(sum+ tmp, max);
                }
            }
        }
        return max;
    }


}
