import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int a =0;
        int b =0;

        if (N.charAt(0) == '0') a++; // 처음 시작하는게 그룹 첫 시작
        else b++;

        for(int i=1;i<N.length();i++){
            if (N.charAt(i-1) != N.charAt(i)) { // 이전 거랑 다음 거랑 같지 않으면 새 그룹 생김
                if (N.charAt(i) == '0') {
                    a++;
                }else{
                    b++;
                }
            }
        }

        System.out.println(Math.min(a, b)); // 그룹 단어 적은 만큼 뒤집기 

    }
}
