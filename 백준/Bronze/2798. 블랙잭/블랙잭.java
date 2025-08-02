import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] s = new int[N];
        for(int i=0;i<N;i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        int max =0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    int sum = s[i]+s[j]+s[k];
                    if(sum<=M&&sum>max){
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);



    }
}
