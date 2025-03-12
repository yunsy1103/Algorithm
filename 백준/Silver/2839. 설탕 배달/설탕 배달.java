import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result =0;

		while(N>0){ // N이 나눠 떨어질때 까지
			if(N%5==0){ // N이 5로 나눠지면 
				result += N/5;
				break;
			}
			else{ // N이 5로 완전히 나눠지지 않을때 3키로 봉투 사용 -1
				N-=3;
				result++;
			}
			if(N<0){ // 3으로 나누어 떨어지지 않을 경우
				result=-1;
			}
		}

		System.out.println(result);
	}
}
