package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11052 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] res = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int input = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                int n1 = res[i - 1][j];
                int n2 = j >= i ? input + res[i][j - i] : res[i - 1][j];
                res[i][j] = Math.max(n1, n2);
            }
        }
        System.out.println(res[N][N]);
    }
}
