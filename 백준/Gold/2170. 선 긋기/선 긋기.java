import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(line, (a, b) -> { // 음수를 반환하면 a가 b보다 앞, 양수를 반환하면 b가 a보다 앞, 0이면 같음
            if (a[0] == b[0]) return a[1] - b[1]; // 두 선분의 시작점을 비교 -> 시작점이 같으면 끝점 기준 오름차순
            return a[0] - b[0];                   // 시작점 기준으로 오름차순
        });


        int sum = 0;
        int curStart = line[0][0]; // 기준점
        int curEnd   = line[0][1];
        for(int i=0;i<N;i++){
            // 선분이 분리되어 있을 경우
            if(line[i][0]>curEnd){ // 새 시작점이 기준점 y 보다 크다면 -> 선분 분리
                sum += curEnd-curStart; // 길이 더하기
                curStart = line[i][0]; // 현재 구간을 다음 선분으로 갱신
                curEnd = line[i][1];

            }
            // 선분 구간이 겹칠 경우
            else{
                curEnd = Math.max(curEnd, line[i][1]); // 현재 선분과 다음 선분 비교해서 더 큰거를 현재 선분으로 두어 확장
            }
        }

        // 연결된 구간없는 마지막 새로운 구간 더하기
        sum += curEnd - curStart;

        System.out.println(sum);

    }
}
