import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        grid = new int[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > maxH) maxH = grid[i][j]; // 최대 높이(maxH) 기록
            }
        }

        // 후보 물 높이
        Set<Integer> cand = new HashSet<>(); // 중복 제거해서 저장
        cand.add(0); // 비가 안올 경우를 생각하여 0 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cand.add(grid[i][j]); // grid에 입력된 물 높이 추가
            }
        }

        int answer =0;
        for (int h : cand) { // 후보에 있는 물 높이로 h 돌림
            int areas = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                     if (!visited[i][j] && grid[i][j] > h) {// 새로운 영역의 시작점
                        DFS(i, j, h);
                        areas++; // 영역 추가
                    }
                }

            }
            answer = Math.max(answer, areas);
        }
        System.out.println(answer);
    }

    // 영역 세기 문제 -> DFS 알고리즘 사용해서 접근
    // 연결된 모든 칸(같은 영역에 속하는 칸)을 재귀로 탐색
    static void DFS(int x,int y,int h){
        visited[x][y] = true;

        for(int dir=0;dir<4;dir++){
            int nx = x+ dx[dir];
            int ny = y+ dy[dir];

            if(nx<0||ny<0||nx>=N||ny>=N) continue;

            if(!visited[nx][ny]&&grid[nx][ny]> h){ // 처음 방문한 위치이면서 h높이 보다 크다면 안전하지 않은 영역
                DFS(nx,ny,h); // 근처 칸 탐색
            }
        }

    }

}
