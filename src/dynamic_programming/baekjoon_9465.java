package dynamic_programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_9465 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] inputs = new int[2][n];
            int[][] res = new int[2][n];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    inputs[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res[0][0] = inputs[0][0];
            res[1][0] = inputs[1][0];
            for(int i=1; i<n; i++){
                if(i==1){
                    res[0][i] = res[1][0] + inputs[0][i];
                    res[1][i] = res[0][0] + inputs[1][i];
                    continue;
                }
                res[0][i] = Math.max(res[1][i-1], res[1][i-2]) + inputs[0][i];
                res[1][i] = Math.max(res[0][i-1], res[0][i-2]) + inputs[1][i];
            }
            bw.write(Math.max(res[0][n-1], res[1][n-1])+"\n");
        }
        bw.close();
    }
}
