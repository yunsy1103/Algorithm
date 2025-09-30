import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> que = new LinkedList<>();
    static int grid[][];
    static int[][] dist;
    static int[] dx={-1,1,0,0,};
    static int[] dy={0,0,-1,1};
    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim(); 
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0'; 
            }
        }
        BFS(0,0);
        System.out.println(dist[N-1][M-1]);

    }

    static void BFS(int sx,int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        dist[sx][sy] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int dir=0;dir<4;dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }

                if(grid[nx][ny]==0||dist[nx][ny]!=0){
                    continue;
                }
                dist[nx][ny] = dist[x][y] +1;
                q.offer(new int[]{nx,ny});
            }
        }

    }

}

