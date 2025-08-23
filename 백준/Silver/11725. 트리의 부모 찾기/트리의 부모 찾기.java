import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int a,b;
    static ArrayList<Integer>[] g;
    static boolean visit[];
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        g = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            g[i] = new ArrayList<>();
        }
        visit = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 0; i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a); 
        }

        parent[1] = 0; 
        DFS(1);

        for(int i=2;i<=N;i++){
            System.out.println(parent[i]);
        }

    }

   
    public static void DFS(int node){
        visit[node] = true;
        for(int next: g[node]){
            if(!visit[next]){
                parent[next]= node;
                DFS(next);
            }

        }

    }

}
