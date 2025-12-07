import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T,I;
    static int endX, endY;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I]; // 배열 초기화는 반드시 bfs를 호출하기 전, 테스트케이스마다 해야함
            dist = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(startX,startY);
            System.out.println(dist[endX][endY]);
        }
        
        visited = new boolean[I][I];
        dist = new int[I][I];

    }

    static void bfs(int startX,int startY) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == endX && y == endY) return;

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
                    continue;
                }

                if (visited[nx][ny]) continue;


                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                que.offer(new int[]{nx, ny});

            }
        }
    }
}
