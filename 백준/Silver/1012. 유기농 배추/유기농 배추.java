import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static boolean[][] visited;
    static int[][] grid;
    static int T,N,M,K;
    static int X,Y;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K= Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            grid = new int[N][M];

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                X= Integer.parseInt(st.nextToken());
                Y= Integer.parseInt(st.nextToken());
                grid[Y][X] = 1;
            }

            int worm = 0;
            for(int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if(!visited[i][j]&&grid[i][j]==1){
                        dfs(i,j);
                        worm++;
                    }
                }
            }

            System.out.println(worm);
        }

    }

    static void dfs(int x,int y){
        visited[x][y]=true;
        for(int dir=0;dir<4;dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<0||ny<0||nx>=N||ny>=M){
                continue;
            }
            if(!visited[nx][ny]&&grid[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}
