import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int piro = 0;
		int work = 0;

		for(int time=0;time<24;time++){
			if(piro+A<=M){
				piro += A;
				work += B;
			}
			else{
				piro -= C;
				if(piro<0){
					piro=0;
				}
			}
		}
		System.out.println(work);


	}
}
