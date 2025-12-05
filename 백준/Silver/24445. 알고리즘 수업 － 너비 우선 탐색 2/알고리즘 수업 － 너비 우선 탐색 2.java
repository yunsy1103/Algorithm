import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R;
    static boolean[] visited;
    static int[] result;
    static ArrayList<Integer> g[];
    static int cnt =1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        g= new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=0;i<=N;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }

        for(int i=0;i<=N;i++){
            Collections.sort(g[i],Collections.reverseOrder());
        }

        Bfs(R);

        StringBuilder sb=new StringBuilder();
        for(int i=1; i<result.length; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }


    static void Bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(R);
        visited[R] = true;
        result[R] = cnt;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for(int i :g[cur]){
                if(!visited[i]){
                    que.offer(i);
                    visited[i] = true;
                    result[i] = ++cnt;
                }
            }
        }
    }
}
