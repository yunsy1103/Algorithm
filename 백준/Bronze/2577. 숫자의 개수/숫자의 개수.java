import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        String result2 = Integer.toString(result);
        char[] s = result2.toCharArray();


        int[] count = new int[10];
        for(int i=0;i<s.length;i++) {
            int digit = s[i] - '0';
            count[digit]++;
        }
        for(int i=0;i<10;i++) {
            System.out.println(count[i]);
        }


    }
}
