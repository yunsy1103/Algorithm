import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] grid;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int w,h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) { //테스트 케이스 수가 지정되지 않고 여러개라 함으로 입력될 때까지 진행
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); //너비-열
            h = Integer.parseInt(st.nextToken()); //높이-행

            grid = new int[h][w];
            visited = new boolean[h][w];

            if (w == 0 && h == 0) break; //종료 0 0 입력되면 반복문 탈출

            for(int i =0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<w;j++){
                    grid[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int land=0;
            for(int i =0;i<h;i++){
                for(int j =0;j<w;j++){
                    if(!visited[i][j]&&grid[i][j]==1){
                        dfs(i,j);
                        land++;
                    }
                }
            }

            System.out.println(land);
        }


    }

    static void dfs(int x,int y){
        visited[x][y]=true;

        for(int dir=0;dir<8;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=h||ny>=w){ //x축 - 행, y축 - 열
                continue;
            }
            if(!visited[nx][ny]&&grid[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}
