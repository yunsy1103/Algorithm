import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = String.valueOf(N);
        int length = s.length();

        int[] count = new int[10];
        for(int i=0;i<length;i++){
            int digit =  N % 10;
            count[digit]++;
            N /= 10;
        }
        count[6] = count[9] = (count[6] + count[9] + 1) / 2;

        int max = 0;
        for (int c : count) {
            if (c > max) max = c;
        }
        System.out.println(max);


    }
}
