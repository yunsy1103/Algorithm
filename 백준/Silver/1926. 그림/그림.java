import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int[][] grid;
    static boolean[][] visited;
    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int draw=0;
        int maxSize=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    int count = dfs(i,j);
                    draw++;
                    maxSize = Math.max(maxSize,count);
                }
            }
        }

        System.out.println(draw);
        System.out.println(maxSize);




    }


    static int dfs(int x,int y){
        visited[x][y]= true;

        int count=1;
        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=n||ny>=m){
                continue;
            }
            if(!visited[nx][ny]&&grid[nx][ny]==1){
                count+=dfs(nx,ny);
            }
        }
        return count;
    }

}


