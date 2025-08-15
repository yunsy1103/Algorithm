import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> que = new LinkedList<>();
    static boolean visited[];
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static int N,M;
    static int max=0;
    static int maxNode =0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist,-1);
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        BFS();

        for(int i=0;i<=N;i++){
            if(dist[i]>max){
                max=dist[i];
                maxNode = i;
            }
        }

        int count =0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=N;i++){
            if(dist[i]==max){
                count++;
                if(i<min)
                    min=i;
            }
        }


        System.out.print(min+" ");
        System.out.print(max+" ");
        System.out.print(count);


    }

    private static void BFS(){
        que.offer(1);
        visited[1]=true;
        dist[1]=0;
        while(!que.isEmpty()){
            int node = que.poll();

            for(int i:adj[node]){
                if(!visited[i]){
                    visited[i]=true;
                    que.offer(i);
                    dist[i]=dist[node]+1;
                }
            }
        }

    }

}
