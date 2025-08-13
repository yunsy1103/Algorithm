
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visited[];
    static ArrayList<Integer> g[];
    static int dist[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            g[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        dist = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        BFS(1);

        int count=0;
        for(int i=0;i<dist.length;i++){
            if(dist[i]==1||dist[i]==2){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void BFS(int cur){
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1]=true;
        dist[1]=0;

        while(!que.isEmpty()){
            cur = que.poll();

            for(int i:g[cur]){
                if(!visited[i]){
                    visited[i]=true;
                    que.offer(i);
                    dist[i]=dist[cur]+1;
                }
            }
        }
    }
}
