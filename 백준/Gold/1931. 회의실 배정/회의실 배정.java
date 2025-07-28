import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(meeting, (a, b) -> {
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        int count =0;
        int lastend =0;
        for (int i = 0; i < N;i++) {
            if(meeting[i][0] >=lastend){
                count++;
                lastend=meeting[i][1];
            }
        }

        System.out.println(count);


    }
}
