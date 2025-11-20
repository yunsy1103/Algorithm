import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] A = new int[T];
        int[] B = new int[T];
        int[] N = new int[T];

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            N[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<T;i++){
            int count=0;
            while (A[i] <= N[i] && B[i] <= N[i]) {
                if(A[i]<B[i]){
                    A[i] +=B[i];
                }else {
                    B[i] +=A[i];
                }
                count++;
            }
            System.out.println(count);
        }

    }
}
