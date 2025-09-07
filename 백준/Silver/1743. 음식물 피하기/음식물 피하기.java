import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int r,c;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            grid[r-1][c-1]=1; 
        }

        int maxSize=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    int count = dfs(i,j);
                    maxSize = Math.max(maxSize,count);
                }
            }
        }

        System.out.println(maxSize);

    }
    static int dfs(int x,int y){
        visited[x][y]=true;
        int count=1;
        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=N||ny>=M){
                continue;
            }
            if(!visited[nx][ny]&&grid[nx][ny]==1){
                count += dfs(nx,ny);
            }
        }
        return count;
    }
}
