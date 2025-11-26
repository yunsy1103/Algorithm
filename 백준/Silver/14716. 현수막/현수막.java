import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int grid[][];
    static boolean visited[][];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8방향(대각선 포함 탐색)
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        grid = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int word=0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]&&grid[i][j]==1){
                    DFS(i,j);
                    word++;
                }
            }
        }

        System.out.println(word);




    }

    static void DFS(int x, int y){
        visited[x][y]=true;

        for(int dir=0;dir<8;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=M||ny>=N){
                continue;
            }

            if(!visited[nx][ny]&&grid[nx][ny]==1){
                DFS(nx,ny);
            }
        }

    }

}
