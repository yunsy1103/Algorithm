import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
        
        int sum = 0;
        String[] numbers = N.split("-");
        for(int i=0;i< numbers.length;i++){
            int temp = 0;
            String[] plusnum = numbers[i].split("\\+");
            for (String num : plusnum) {
                temp += Integer.parseInt(num);
            }

            if (i == 0) {
                sum += temp; // i가 첫번째 것일 때 더하고
            }
            else{
                sum -= temp; // 그 이후일 땐 빼서 최솟값만들기
            }
        }

        System.out.println(sum);


	}
}
