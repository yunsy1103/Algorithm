import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] cup = {1, 0, 0};

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int temp = cup[x];
            cup[x] = cup[y];
            cup[y] = temp;
        }
        if (cup[0] == 1) {
            System.out.println(1);
        } else if (cup[1] == 1) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
