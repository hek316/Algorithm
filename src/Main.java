import java.io.*;
import java.util.ArrayList;;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
    int v, dist;
    public Node(int v, int dist){
        this.v = v;
        this.dist = dist;
    }
}

public class Main{
    static ArrayList<Node>[] arr ;
    static  int[] deptArr;
    static  int[] parents;
    static  int[] distArr;
    static int MAX = 0;
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        deptArr = new int[n+1];
        parents = new int[n+1];
        distArr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true){
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                arr[u].add(new Node(v,dist));
            }
        }

        dfs(1,-1,1);

        int[] deptSum = new int[n+1];

        // 같은 레벨끼리 더하기
        int[] levelCompare = new int[n+1];
        while (!stack.isEmpty()){
            // 노드 꺼내기
            int pop = stack.pop();
            int parent = parents[pop];
            if (parent == 0){
                System.out.println(MAX);
                return;}
            if( deptSum[pop] == 0){
                deptSum[pop] = distArr[pop];
            }
            int tmp = deptSum[pop] + distArr[parent];
            deptSum[parent] = Math.max(tmp, deptSum[parent]);
            int childMax =levelCompare[parent] +deptSum[pop] ;
            // 같은 레벨에서 더한 값 비교
            MAX = Math.max(MAX,  childMax);
            // 같은 부모중에 가장 큰 자식 고르기
            levelCompare[parent] = Math.max(deptSum[pop], levelCompare[parent]);
            MAX = Math.max(MAX,  deptSum[parent]);
        }
    }

    static void dfs(int root, int pre, int dept){
        stack.push(root);
        for(Node y : arr[root]){
            if(y.v == pre){
                continue;
            }
            deptArr[y.v] = dept;
            parents[y.v] = root;
            distArr[y.v] = y.dist;

            dfs(y.v, root, dept+1);
        }
    }
}