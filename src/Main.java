import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static class HideAndSeek{
        // 수빈이의 위치
        int x;
        int time;
        public HideAndSeek(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
    static int N;
    static int goal;
    static int MAX = 200001;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =  Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        if(N == goal){
            System.out.println("0");
            return;
        }
        arr = new int[MAX];
        visited = new boolean[MAX];

        Queue<HideAndSeek> queue = new LinkedList<HideAndSeek>();
        queue.add(new HideAndSeek(N, 0));
        while (!queue.isEmpty()){
            // Teleportation
            HideAndSeek h = queue.remove();
            int next = 2*h.x;
            if(next < MAX){
                if(visited[next] == false){
                    visited[next] = true;
                    arr[next] = h.time;
                    queue.add(new HideAndSeek(next, h.time));
                } else if(visited[next] && h.time < arr[next]){
                    arr[next] = h.time;
                    queue.add(new HideAndSeek(next, h.time));
                }
            }

            next = h.x + 1;
            if(next < MAX){
                if(visited[next] == false){
                    visited[next] = true;
                    arr[next] = h.time+1;
                    queue.add(new HideAndSeek(next, h.time+1));
                } else if(visited[next] && h.time+1 < arr[next]){
                    arr[next] = h.time + 1;
                    queue.add(new HideAndSeek(next, h.time+1));
                }
            }

            next = h.x - 1;
            if(next >= 0){
                if(visited[next] == false){
                    visited[next] = true;
                    arr[next] = h.time+1;
                    queue.add(new HideAndSeek(next, h.time+1));
                } else if(visited[next] && h.time+1 < arr[next]){
                    arr[next] = h.time + 1;
                    queue.add(new HideAndSeek(next, h.time+1));
                }
            }
        }

        System.out.println(arr[goal]);

    }
}