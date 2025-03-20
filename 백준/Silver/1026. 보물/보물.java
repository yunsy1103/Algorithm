
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);


		int S = Integer.MAX_VALUE;
		int s=0;
		for(int i=0; i<N; i++){
			s += A[i] * B[(N-1)-i];
		}
		S = Math.min(S, s); 
		System.out.println(S);

	}
}
