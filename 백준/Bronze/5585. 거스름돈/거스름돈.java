import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());


		int T = 1000-K;

		int A = T/500;
		T %= 500;
		int B = T/100;
		T %= 100;
		int C = T/50;
		T %= 50;
		int D = T/10;
		T %= 10;
		int E = T/5;
		T %= 5;
		int F = T/1;
		T %= 1;

		System.out.println(A+B+C+D+E+F);



	}
}
