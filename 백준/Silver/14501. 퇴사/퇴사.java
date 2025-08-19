import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] max = new int[N+1];
        for(int i=0;i<N;i++){
            if(i+T[i]<=N){
               max[i+T[i]]=Math.max(max[i+T[i]],max[i]+P[i]);
            }
            max[i+1] = Math.max(max[i+1],max[i]);
        }
        
        System.out.println(max[N]);
    }
}
