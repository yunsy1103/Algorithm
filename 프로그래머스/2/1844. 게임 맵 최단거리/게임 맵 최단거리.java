import java.util.*;


class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int[][] dist;
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        visited = new boolean[n][m];
        
        return bfs(0, 0, maps, n, m);
    
    }
    
    
     public int bfs(int sx, int sy, int[][] maps, int n, int m) {
         Queue<int[]> que = new LinkedList<>();
         que.offer(new int[]{sx, sy});
         visited[sx][sy] = true;

         dist = new int[n][m];
         dist[sx][sy] = 1;
         
         
         while(!que.isEmpty()){
             int[] cur = que.poll();
             
             int x = cur[0];
             int y = cur[1];
             
             // 도착 지점에 오면 바로 반환시, 길이 반환
             // BFS는 최단거리를 보장하므로 별도의 거리 비교 로직 필요없음
             if(x==n-1&&y==m-1){
                 return dist[x][y];
              }
             
             for(int dir=0;dir<4;dir++){
                 int nx = x + dx[dir];
                 int ny = y + dy[dir];
                 
                 if(nx<0||ny<0||nx>=n||ny>=m)
                     continue;
                
                 if (visited[nx][ny] || maps[nx][ny] == 0) continue;

                  visited[nx][ny] = true;
                  dist[nx][ny]=dist[x][y]+1;
                  que.offer(new int[]{nx, ny});
            
             }
         }return -1;
     }
}