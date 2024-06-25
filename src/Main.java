import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int left, right, level, order;
    Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}

public class Main{
    static int deptMax = 1;
    static int order = 1;
    static void inOrder(Node[] node, int x, int dept){
        if(x == -1){
            return;
        }
        node[x].level = dept;
        deptMax = Math.max(deptMax, dept);
        inOrder(node, node[x].left, dept+1);
        node[x].order = order++;
        inOrder(node, node[x].right, dept+1);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] node = new Node[n + 1];
        StringTokenizer st;

        // root 노드 찾기
        int[] prents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            node[root] = new Node(left, right);
            if (left != -1) {
                prents[left] = root;
            }
            if (right != -1) {
                prents[right] = root;
            }
        }

        int rootNode = 1;
        for (int i = 1; i <= n; i++) {
            if (prents[i] == 0) {
                rootNode = i;
                break;
            }
        }

        inOrder(node, rootNode, 1);
        int ansL = 1;
        int ansD = 1;
        for (int i = 2; i <= deptMax; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (i == node[j].level) {
                    min = Math.min(min, node[j].order);
                    max = Math.max(max, node[j].order);
                }
            }
            int m = max - min + 1;
            if (m > ansD) {
                ansL = i;
                ansD = m;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ansL).append(" ").append(ansD);

        System.out.println(sb);
    }
}