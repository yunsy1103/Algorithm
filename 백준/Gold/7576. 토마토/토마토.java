import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int N,M;
    static boolean[][] visited;
    static int[][] tomato;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        tomato = new int[N][M];


        int count =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j]==1){
                    que.offer(new int[]{i, j});
                }
            }
        }

        Bfs();

        int max =0;
        for(int i=0;i<N;i++){
            for(int j = 0; j <M; j++){
                if(tomato[i][j]== 0){ // bfs 돌리고 탐색했을 때, 안익은 토마토가 하나라도 있으면 바로 return;
                    System.out.println(-1);
                    return; // 바로 종료

                }
                else{
                    max = Math.max(max, tomato[i][j]); // 토마토가 다 익을 경우에 리턴
                }
            }
        }
        
        System.out.println(max - 1);

    }

    static void Bfs(){

        while (!que.isEmpty()){
            int[] cur = que.poll();
            int x= cur[0];
            int y= cur[1];

            for(int dir=0;dir<4;dir++){
                int nx = x + dx[dir];
                int ny= y + dy[dir];
                if(nx<0|| ny<0||nx>=N||ny>=M){
                    continue;
                }

                if(tomato[nx][ny]==0){
                    tomato[nx][ny] = tomato[x][y] + 1; // 안익은 토마토 값 기준으로 +1해서 더해짐 -> 1부터 시작
                    que.offer(new int[]{nx, ny});
                }
            }

        }

    }
}
