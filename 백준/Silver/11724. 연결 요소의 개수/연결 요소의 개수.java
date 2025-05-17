import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Edge_arr[][];
    static boolean Visited_arr[];
    static int N;
    static int M;
    static int u,v;
    static int count;

    public static void DFS(int start){
        Visited_arr[start]=true;
        
        for(int i=1;i<=N;i++){
            if(Edge_arr[start][i]==1&&Visited_arr[i]==false){
                DFS(i);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Edge_arr=new int[1001][1001];
        Visited_arr=new boolean[1001];

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            Edge_arr[u][v]=Edge_arr[v][u]= 1; // 무방향 그래프
        }

        for(int i=1; i<=N; i++) {
            if(!Visited_arr[i]) {
                DFS(i);
                count ++;
            }
        }

        System.out.println(count);
    }
}
