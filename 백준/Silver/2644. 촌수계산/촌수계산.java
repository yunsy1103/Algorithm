import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean visited[];
    static int parent[];
    static int x,y;
    static int answer;
    static int resultX,resultY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 총 사람 수

        st = new StringTokenizer(br.readLine());
        resultX = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
        resultY = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수

        g = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        // 리스트 초기화 
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            g[x].add(y);
            g[y].add(x); // 양방향
        }

        answer=-1; // 촌수 없을 때, 기본 -1
        DFS(resultX,0);
        System.out.println(answer);

    }

    public static void DFS(int node,int depth){
        if (node == resultY) { 
            answer = depth; // 현재까지의 촌수 저장
            return;
        }

        visited[node] = true;
        
        for(int next: g[node]){
            if(!visited[next]){
                DFS(next,depth+1); // 다음으로 이어지면 촌수 +1
            }

        }

    }
}
