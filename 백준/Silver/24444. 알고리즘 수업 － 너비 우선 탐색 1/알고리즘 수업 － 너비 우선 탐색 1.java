import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R;
    static boolean[] visited;
    static int[] result;
    static ArrayList<Integer> g[];
    static int cnt=1; // BFS를 시작하자마자 시작 정점 r은 첫 번째 방문한 정점이므로 기본적으로 1이 들어감
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        g=new ArrayList[N+1];
        result = new int[N+1];
        visited = new boolean[N+1];

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(g[i]);
        }

        Bfs(R);

        StringBuilder sb=new StringBuilder();
        for(int i=1; i<result.length; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

    }

    // cnt:몇 번째로 방문한 정점인지 기록하는 방문 순서 번호
    static void Bfs(int R){
        Queue<Integer> que = new LinkedList<>();
        que.offer(R);
        visited[R]=true;
        result[R] = cnt; // 시작 정점은 1번째 방문

        while (!que.isEmpty()){
            int cur = que.poll(); // 큐가 비어있지 않다면 해당 원소를 뺌

            for(int i: g[cur]){
                if(!visited[i]) { // 방문하지 않았다면
                    que.offer(i); // 해당 원소를 큐에 삽입
                    visited[i]=true;
                    result[i] =++cnt;// 방문 순서 증가 -> 정점 i가 BFS에서 몇 번째로 방문되었는가가 result[]에 저장됨
                }
            }

        }

    }
}

/*
cnt++이 아니라 ++cnt여야 하는 이유
-> cnt는 기본 1부터 시작하기 때문에 cnt++하면 다음거도 1이 저장되고 +1 증가함,
   ++cnt로 해야 바로 다음거에서 2로 저장됨.
 */
