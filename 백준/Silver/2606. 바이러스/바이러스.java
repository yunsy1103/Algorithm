import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Queue<Integer> que = new LinkedList<>();
    static int arr[][];
    static boolean visited[];

    static int N,M;
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        arr = new int[N+1][N+1];
        for(int i=0;i<M;i++){
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             arr[x][y]=1;
             arr[y][x]=1;
        }
        BFS();
        System.out.println(result);

    }

    private static void BFS(){
        que.offer(1);
        visited[1] = true;

        while(!que.isEmpty()){
            int node = que.poll();

            for(int i=0;i<N+1;i++){
                //1이 아니거나 visited[]이 true일 경우, 그냥 통과
                //arr[node][i]!=1 -> 현재 node와 i 사이에 간선이 없다면 건너뛴다
                if(arr[node][i]!=1||visited[i] == true){
                    continue;
                }
                que.offer(i);
                visited[i] = true;
                result++;
            }
        }
    }
}
