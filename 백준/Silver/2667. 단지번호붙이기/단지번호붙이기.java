import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int N;
    static int[][] grid;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> list = new ArrayList<>();
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }


        for(int i =0;i<N;i++) {
            for(int j =0;j<N;j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    int count = dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int count: list){
            System.out.println(count);
        }

    }

    static int dfs(int x,int y) {
        visited[x][y] = true;
        int count = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (!visited[nx][ny] && grid[nx][ny] == 1) {
                count += dfs(nx, ny);
            }
        }

        return count; 
    }
}
