import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[5];
        for(int i=0;i<5;i++){
            A[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        int sum =0;
        for(int a:A){
           sum+=a;
        }

        System.out.println(sum/5);
        System.out.println(A[2]);

    }
}
