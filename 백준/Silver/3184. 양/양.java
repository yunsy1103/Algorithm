import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char grid[][];
    static boolean visited[][];
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        visited = new boolean[R][C];
        grid = new char[R][C];

        for(int i=0;i<R;i++){
            String line = br.readLine();
            for(int j = 0; j <C; j++){
                grid[i][j] = line.charAt(j);
            }
        }


        int totalSheep = 0;
        int totalWolf = 0;

        for(int i=0;i<R;i++){
            for(int j = 0; j <C; j++){
                if(!visited[i][j]&&grid[i][j]!='#'){
                    int[] count = new int[2];
                    DFS(i,j,count);

                    if(count[0]>count[1]){
                        totalSheep += count[0];
                    }
                    else {
                        totalWolf += count[1];
                    }
                }
            }
        }

        System.out.println(totalSheep+" "+totalWolf);



    }

    static void DFS(int x, int y, int[] count){
        visited[x][y] = true;

        // 현재 칸 방문했을 때, 지금 칸이 'o'인지 'v'인지 카운트
        if (grid[x][y] == 'o') count[0]++;
        if (grid[x][y] == 'v') count[1]++;


        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=R||ny>=C){
                continue;
            }

            if(!visited[nx][ny]&&grid[nx][ny]!='#'){
                DFS(nx,ny,count);
            }
        }


    }
}
