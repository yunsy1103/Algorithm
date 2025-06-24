import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        for(int a:A){
            System.out.println(a);
        }
        br.close();

    }
}
