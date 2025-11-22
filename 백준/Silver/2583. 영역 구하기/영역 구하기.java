import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] grid;
    static boolean[][] visited;
    static int white, blue;
    static int[] dx={-1,1,0,0,};
    static int[] dy={0,0,-1,1};
    static int N,M,K;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        M =Integer.parseInt(st.nextToken()); // y축
        N =Integer.parseInt(st.nextToken()); // x축
        K =Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        visited = new boolean[M][N];

        // x,y 입력받고 그만큼 1로 표시
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    grid[y][x] = 1; // 직사각형 영역 1로 칠하기
                }
            }
        }

        for(int i =0;i<M;i++) {
            for(int j =0;j<N;j++) {
                if(grid[i][j]==0 && !visited[i][j]){
                    int count = dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int count: list){
            System.out.print(count+" ");
        }


    }

    static int dfs(int y,int x) {
        visited[y][x] = true;
        int count = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (!visited[ny][nx] && grid[ny][nx] == 0) { // 0인 곳 찾아서 넓이 count (직사각형 없는 곳)
                count += dfs(ny, nx);
            }
        }

        return count; //bfs 한 번 돌면 총 연결된 집 수 리턴
    }

}
