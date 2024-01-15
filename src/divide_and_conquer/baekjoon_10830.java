package divide_and_conquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_10830 {

    public static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] matrix = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        List<Long> divides = new ArrayList<>();
        while(B != 0){
            divides.add(0,B);
            B = B/2;
        }
        int[][][] res = new int[divides.size()][N][N];
        res[0] = matrix;
        for(int i=1; i<divides.size(); i++){
            res[i] = mulMatrix(res[i-1], res[i-1]);
            if(divides.get(i) % 2 == 1){
                res[i] = mulMatrix(res[i], matrix);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(res[divides.size()-1][i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    public static int[][] mulMatrix(int[][] a, int[][] b){
        int[][] res = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % 1000;
                }
            }
        }
        return res;
    }
}
