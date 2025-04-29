import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine()); 
            array[i] = n;
            sum += array[i];
        }

        Arrays.sort(array);

        int a = 0;
        int b = 0;

   
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (sum - array[i] - array[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != a && i != b) {
                System.out.println(array[i]);
            }
        }
    }
}