import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] oil = new int[N];
        int[] distance = new int[N-1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            oil[i] = Integer.parseInt(st.nextToken());
        }
       
        int min = oil[0];
        int sum =0;
        for(int i=0;i<N-1;i++){
            if(min>oil[i]){
                min=oil[i];
            }
            sum += min*distance[i];
        }
        System.out.println(sum);


    }
}
