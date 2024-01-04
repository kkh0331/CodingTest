package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] values = new int[N];
        int count = 0; //동전 개수
        for(int i=N-1; i>=0; i--) {
            values[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N; i++) {
            count += K/values[i];
            K = K % values[i];
            if(K == 0) {
                System.out.println(count);
                break;
            }
        }
    }
}
