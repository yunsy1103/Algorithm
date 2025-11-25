import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[][];
    static char grid[][];
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];  // M,N 위치 주의
        grid = new char[M][N];

        for(int i=0;i<M;i++){
            String line = br.readLine();
            for(int j = 0; j <N; j++){
                grid[i][j] = line.charAt(j);
            }
        }


        int countW=0;
        int countB=0;
        for(int i=0;i<M;i++){
            for(int j = 0; j <N; j++){
                if(!visited[i][j]){
                    char color = grid[i][j];
                    int count = DFS(i,j,color);

                    if(color=='W'){
                        countW += count*count; // (연결된) 여러 덩어리로 떨어져 있을 수 있으므로 누적합
                    }
                    else{
                        countB += count*count;
                    }
                }
            }
        }

        System.out.println(countW+" "+countB);


    }


    static int DFS(int x, int y, char color){
        int count=1;
        visited[x][y] =true;

        for(int dir=0;dir<4;dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<0||ny<0||nx>=M||ny>=N){
                continue;
            }
            if(!visited[nx][ny]&&grid[nx][ny]==color){
                count += DFS(nx,ny,color);
            }
        }

        return count; // 상하좌우로 연결되어 있는 같은 색 개수 count 리턴 
    }

}
