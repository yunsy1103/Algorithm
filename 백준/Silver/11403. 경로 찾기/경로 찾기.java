import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int g[][];
    static int answer[][];
    static int N;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        g = new int[N][N];
        answer = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, i, visited);
        }

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }


    }

       public static void DFS(int start,int cur,boolean[] visited){
        for(int next = 0;next<N;next++){
            if(g[cur][next] ==1&&visited[next]==false){
                answer[start][next] = 1;
                visited[next]=true;
                DFS(start,next,visited);
            }
        }
    }
}
