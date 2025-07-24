import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();

		int sum = 0;
		char[] b = new char[N.length()];
		for (int i = 0; i < N.length(); i++) {
			b[i] = N.charAt(i);
			sum += b[i];
		}
		if (sum % 3 != 0 || !N.contains("0")) {
			System.out.println(-1);
			return;
		}

		Arrays.sort(b);
		String result="";
		for (int i = N.length() - 1; i >= 0; i--) {
			result+=b[i];
		}

		System.out.println(result);
	}
}
