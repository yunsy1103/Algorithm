import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int grid[][];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        grid = new int[5][5];


        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 1, String.valueOf(grid[i][j]));
            }
        }

        System.out.println(set.size());

    }

    static void DFS(int x, int y,int depth, String num){
        if (depth == 6) { // 6글자를 만들면 숫자 저장
            set.add(num);
            return;
        }


        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0||ny<0||nx>=5||ny>=5){
                continue;
            }

            DFS(nx, ny, depth + 1, num + grid[nx][ny]);

        }
    }

}
